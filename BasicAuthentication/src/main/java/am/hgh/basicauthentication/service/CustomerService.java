package am.hgh.basicauthentication.service;

import am.hgh.basicauthentication.entity.CustomerEntity;
import am.hgh.basicauthentication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

//     here should be autowired dto
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.getById(customerId);
    }
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }
    public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

}
