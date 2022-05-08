package am.hgh.basicauthentication.security;

import am.hgh.basicauthentication.entity.CustomerDetailsEntity;
import am.hgh.basicauthentication.entity.CustomerEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class CustomerDetails implements UserDetails {
    private final String password;
    private String userName;
    private boolean expired;
    private boolean locked;
    private boolean credentials;
    private final boolean active;
    List<GrantedAuthority> authorityList;

    public CustomerDetails(CustomerDetailsEntity customerDetails) {
        this.password = customerDetails.getPassword();
        this.userName = customerDetails.getUserName();
        this.expired = customerDetails.isExpired();
        this.locked = customerDetails.isLocked();
        this.credentials = customerDetails.isCredentials();
        this.active = customerDetails.isActive();
        this.authorityList = Arrays.stream(customerDetails.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return expired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return credentials;
    }
    @Override
    public boolean isEnabled() {
        return active;
    }
}
