package am.hgh.basicauthentication.unittest.controller;


import am.hgh.basicauthentication.dto.CustomerDto;
import am.hgh.basicauthentication.utils.DummyCustomer;
import am.hgh.basicauthentication.utils.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    void getAllCustomers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/customer/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty());
    }
    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    void getCustomerById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/customer/{customerId}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    void createCustomer() throws Exception {
        CustomerDto customer2create = DummyCustomer.customerDto(3L, 3L, 3L);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/customer/create")
                .contentType(gson.toJson(customer2create))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3));
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    void updateCustomer() throws Exception{
        CustomerDto customer2update = DummyCustomer.customerDto(3L, 3L, 3L);
        mockMvc.perform(MockMvcRequestBuilders
                .put("/customer/update", 1)
                .content(gson.toJson(customer2update))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    @WithMockUser(username="admin",roles={"ADMIN"})
    void deleteCustomerById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/customer/{customerId}", 1))
                .andExpect(status().isNoContent());
    }

}
