package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(UUID uuid);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    Optional<CustomerDTO> updateCustomerById(UUID id, CustomerDTO customer);

    Boolean deleteById(UUID customerId);

    Optional<CustomerDTO> patchById(UUID customerId, CustomerDTO customer);
}
