package corp.bi.go.id.api.pintar.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.facade.response.Customer;
import corp.bi.go.id.api.pintar.facade.response.CustomerList;
import org.springframework.http.ResponseEntity;

public interface CustomerFacade {
    ResponseEntity<ApiResponse<CustomerList>> getAll();

    ResponseEntity<ApiResponse<Customer>> get(String id);
}
