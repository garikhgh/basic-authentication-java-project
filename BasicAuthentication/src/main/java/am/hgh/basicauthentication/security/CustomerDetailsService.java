package am.hgh.basicauthentication.security;

import am.hgh.basicauthentication.entity.CustomerDetailsEntity;
import am.hgh.basicauthentication.entity.CustomerEntity;
import am.hgh.basicauthentication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customerEntity = customerService.findCustomerByName(username);
        CustomerDetailsEntity details = customerEntity.getCustomerDetailsEntity();
        return new CustomerDetails(details);
    }
}
