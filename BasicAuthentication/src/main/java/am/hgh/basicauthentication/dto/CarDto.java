package am.hgh.basicauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String carName;
    private String carBrand;
    private Date makeYear;
    private int km;
}
