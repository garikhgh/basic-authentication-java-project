package am.hgh.basicauthentication.service;

import am.hgh.basicauthentication.dto.CustomerDto;
import am.hgh.basicauthentication.entity.CustomerEntity;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IUserService {

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public List<CustomerEntity> getAllCustomers();
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public CustomerEntity getCustomerById(Long customerId);
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public CustomerEntity createCustomer(CustomerDto customerDto);
    @Secured({"ROLE_ADMIN"})
    public CustomerEntity updateCustomer(CustomerDto customerDto);
    @Secured({"ROLE_ADMIN"})
    public void deleteCustomerById(Long customerId);

}
