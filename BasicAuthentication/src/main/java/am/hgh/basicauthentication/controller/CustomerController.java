package am.hgh.basicauthentication.controller;

import am.hgh.basicauthentication.dto.CustomerDto;
import am.hgh.basicauthentication.entity.CustomerEntity;
import am.hgh.basicauthentication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok(customerList);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long customerId) {
        CustomerEntity customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }
    @PostMapping("/create")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerEntity createdCustomer = customerService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
    @PutMapping("/update")
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerDto customerDto) {
        CustomerEntity updatedCustomer = customerService.updateCustomer(customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }
}
