package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entites.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoriesTest {

    @Autowired
    CustomerRepositories customerRepositories;

    @Test
    void testSaveCustomer() {
        Customer saveCustomer = customerRepositories.save(Customer
                .builder()
                .name("My Customer")
                .build());

        assertThat(saveCustomer.getId()).isNotNull();
    }
}