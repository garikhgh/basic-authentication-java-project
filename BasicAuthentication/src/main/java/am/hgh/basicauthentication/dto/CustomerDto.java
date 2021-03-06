package am.hgh.basicauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String customerName;
    private List<CarDto> customerCarDto;
    private CustomerDetailsDto customerDetailsDto;
}
