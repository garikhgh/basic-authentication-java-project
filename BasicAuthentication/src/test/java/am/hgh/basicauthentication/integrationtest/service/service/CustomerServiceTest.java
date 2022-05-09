package am.hgh.basicauthentication.integrationtest.service.service;

import am.hgh.basicauthentication.dto.CustomerDto;
import am.hgh.basicauthentication.entity.CustomerDetailsEntity;
import am.hgh.basicauthentication.entity.CustomerEntity;
import am.hgh.basicauthentication.service.CustomerService;
import am.hgh.basicauthentication.utils.DummyCustomer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import java.util.List;


@ActiveProfiles("integration")
@TestPropertySource(locations = "classpath:application-integration.properties")
@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Test
    void getAllCustomers() {
        List<CustomerEntity> allCustomers = customerService.getAllCustomers();
        Assertions.assertEquals(2, allCustomers.size());
    }
    @Test
    void getCustomerById() {
        CustomerEntity customerById = customerService.getCustomerById(2L);
        Assertions.assertEquals(customerById.getId(), 2);
    }
    @Test
    void createCustomer() {
        CustomerDto createCustomer = DummyCustomer.customerDto(3L, 3L, 3L);
        CustomerEntity createdCustomer = customerService.createCustomer(createCustomer);
        Assertions.assertEquals(createdCustomer.getId(), 3);
    }
    @Test
    void updateCustomer() {
        CustomerDto updateCustomer = DummyCustomer.customerDto(1L, 1L, 1L);
        CustomerEntity updatedCustomer = customerService.createCustomer(updateCustomer);
        Assertions.assertNotNull(updatedCustomer.getId());
    }
    @Test
    void deleteCustomerById() {
        customerService.deleteCustomerById(1L);
        CustomerEntity deletedCustomer = customerService.getCustomerById(1L);
        Assertions.assertNull(deletedCustomer);
    }
    @Test
    void findCustomerByName() {
        CustomerDetailsEntity customerByName = customerService.findCustomerByName("neo");
        Assertions.assertEquals("neo", customerByName.getUserName());
    }
}