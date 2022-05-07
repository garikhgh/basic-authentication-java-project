package am.hgh.basicauthentication.security;

import am.hgh.basicauthentication.entity.CustomerEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomerDetails implements UserDetails {

    private String password;
    private String userName;
    private boolean expired;
    private boolean locked;
    private boolean credentials;
    private boolean active;
    private List<GrantedAuthority> authorityList;

    public CustomerDetails(CustomerEntity customerEntity) {
        this.password=customerEntity.getpassword();
        this.userName= customerEntity.getUserName();
        this.expired = customerEntity.getExpired();
        this.locked = customerEntity.getLocked();
        this.credentials = customerEntity.credentials();
        this.active = customerEntity.getActive();
        this.authorityList = Arrays.stream(customerEntity.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .colletct(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
