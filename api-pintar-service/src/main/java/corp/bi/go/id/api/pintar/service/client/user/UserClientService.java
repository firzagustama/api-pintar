package corp.bi.go.id.api.pintar.service.client.user;

import corp.bi.go.id.ap.user.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientService {
    @Autowired
    private CustomerServiceGrpc.CustomerServiceBlockingStub customerBlockingStub;

    public CustomerList getAllCustomer() {
        return customerBlockingStub.getAll(Empty.newBuilder().build());
    }

    public Customer getCustomer(CustomerRequestId request) {
        return customerBlockingStub.get(request);
    }
}
