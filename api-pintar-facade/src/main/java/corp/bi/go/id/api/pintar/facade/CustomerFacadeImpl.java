package corp.bi.go.id.api.pintar.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.ap.user.grpc.CustomerRequestId;
import corp.bi.go.id.api.pintar.facade.response.Customer;
import corp.bi.go.id.api.pintar.facade.response.CustomerList;
import corp.bi.go.id.api.pintar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerFacadeImpl implements CustomerFacade {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    @Override
    public ResponseEntity<ApiResponse<CustomerList>> getAll() {
        List<Customer> data = customerService.getAll().getCustomersList().stream()
                .map(c -> {
                    Customer cust = new Customer();
                    cust.setId(c.getId());
                    cust.setEmail(c.getEmail());
                    cust.setName(c.getName());
                    return cust;
                }).toList();

        CustomerList body = new CustomerList();
        body.setCustomers(data);

        ApiResponse<CustomerList> response = new ApiResponse<>();
        response.setResponseCode("1000");
        response.setResponseMessage("success");
        response.setResponseData(body);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Override
    public ResponseEntity<ApiResponse<Customer>> get(@RequestParam String id) {
        corp.bi.go.id.ap.user.grpc.Customer data = customerService.get(CustomerRequestId.newBuilder().setId(id).build());

        Customer body = new Customer();
        body.setId(data.getId());
        body.setEmail(data.getEmail());
        body.setName(data.getName());

        ApiResponse<Customer> response = new ApiResponse<>();
        response.setResponseCode("1000");
        response.setResponseMessage("success");
        response.setResponseData(body);

        return ResponseEntity.ok(response);
    }
}
