package corp.bi.go.id.api.pintar.application.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.application.PintarApplicationTest;
import corp.bi.go.id.api.pintar.application.config.ClientServiceTestConfig;
import corp.bi.go.id.api.pintar.facade.response.Customer;
import corp.bi.go.id.api.pintar.facade.response.CustomerList;
import org.junit.Test;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(ClientServiceTestConfig.class)
public class CustomerFacadeTest extends PintarApplicationTest {
    @Test
    public void getAllCustomer_success() throws Exception {
        ApiResponse<CustomerList> response = get("/customer/all", CustomerList.class);
        assertEquals(response.getResponseCode(), "1000");
        assertEquals(response.getResponseMessage(), "success");

        CustomerList responseData = response.getResponseData();
        assertEquals(responseData.getCustomers().stream().count(), 3);
        assertEquals(responseData.getCustomers().get(0).getId(), "111");
    }

    @Test
    public void getCustomer_success() throws Exception {
        String customerId = "112";

        ApiResponse<Customer> response = get("/customer?id=" + customerId, Customer.class);
        assertEquals(response.getResponseCode(), "1000");
        assertEquals(response.getResponseMessage(), "success");

        Customer responseData = response.getResponseData();
        assertEquals(responseData.getId(), customerId);
    }
}