package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerServices {

    List<Customer> getAllCustomers();

    Customer getCustomerById(UUID uuid);
}
