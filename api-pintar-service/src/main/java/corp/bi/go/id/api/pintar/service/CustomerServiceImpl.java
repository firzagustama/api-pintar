package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.user.grpc.Customer;
import corp.bi.go.id.ap.user.grpc.CustomerList;
import corp.bi.go.id.ap.user.grpc.CustomerRequestId;
import corp.bi.go.id.api.pintar.service.client.user.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserClientService userClientService;

    @Override
    public CustomerList getAll() {
        return userClientService.getAllCustomer();
    }

    @Override
    public Customer get(CustomerRequestId request) {
        return userClientService.getCustomer(request);
    }
}
