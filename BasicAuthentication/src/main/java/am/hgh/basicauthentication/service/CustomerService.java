package am.hgh.basicauthentication.service;

import am.hgh.basicauthentication.dto.CustomerDto;
import am.hgh.basicauthentication.entity.CustomerDetailsEntity;
import am.hgh.basicauthentication.entity.CustomerEntity;
import am.hgh.basicauthentication.mapper.CustomerMapper;
import am.hgh.basicauthentication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

//     here should be autowired dto
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }
    public CustomerEntity createCustomer(CustomerDto customerDto) {
        CustomerEntity createdCustomer = customerMapper.dto2Customer(customerDto);
        return customerRepository.save(createdCustomer);
    }
    public CustomerEntity updateCustomer(CustomerDto customerDto) {
        CustomerEntity updatedCustomer = customerMapper.dto2Customer(customerDto);
        return customerRepository.save(updatedCustomer);
    }
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }
    public CustomerDetailsEntity findCustomerByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }

}
