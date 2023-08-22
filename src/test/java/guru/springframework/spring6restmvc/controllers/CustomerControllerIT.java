package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.entites.Customer;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.repositories.CustomerRepositories;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerIT {
    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepositories customerRepositories;

    @Test
    void testCustomerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        Customer customer = customerRepositories.findAll().get(0);

        CustomerDTO dto = customerController.getCustomerById(customer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListCustomers() {
        List<CustomerDTO> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        customerRepositories.deleteAll();

        List<CustomerDTO> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }
}