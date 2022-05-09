package am.hgh.basicauthentication.utils;

import am.hgh.basicauthentication.dto.CarDto;
import am.hgh.basicauthentication.dto.CustomerDetailsDto;
import am.hgh.basicauthentication.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;


public class DummyCustomer {

    public DummyCustomer() {}

    public static CustomerDto customerDto(Long customerId, Long carId, Long customerDetailsId){
        CarDto carDto = new CarDto(carId, "Fuga", "Nissan",
                null, 10000);
        CustomerDetailsDto customerDetails = new CustomerDetailsDto(customerDetailsId, "abc",
                "neo", false, false, true,true, "ROLE_ADMIN" );
        List<CarDto> carDtoList = new ArrayList<>();
        carDtoList.add(carDto);
        return  new CustomerDto(customerId, "Jack Jack", carDtoList, customerDetails);
    }
}
