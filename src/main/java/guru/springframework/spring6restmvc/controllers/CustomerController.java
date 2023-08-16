package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId")UUID id){
        return  customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){
        Customer saveNewCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+saveNewCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerById(@PathVariable("customerId") UUID id, @RequestBody Customer customer){
        customerService.updateCustomerById(id,customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable UUID customerId){
        customerService.deleteById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

