package am.hgh.basicauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {
    private Long id;
    private String password;
    private String userName;
    private boolean expired;
    private boolean locked;
    private boolean credentials;
    private boolean active;
    private String authorityList;

}
