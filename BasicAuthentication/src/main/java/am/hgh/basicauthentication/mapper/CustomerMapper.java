package am.hgh.basicauthentication.mapper;

import am.hgh.basicauthentication.dto.CustomerDto;
import am.hgh.basicauthentication.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customerCarDto", source = "customerCar")
    CustomerDto customer2Dto(CustomerEntity customerEntity);

    @Mapping(target = "customerCar", source = "customerCarDto")
    CustomerEntity dto2Customer(CustomerDto customerDto);
}
