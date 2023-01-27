package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.user.grpc.Customer;
import corp.bi.go.id.ap.user.grpc.CustomerList;
import corp.bi.go.id.ap.user.grpc.CustomerRequestId;

public interface CustomerService {
    CustomerList getAll();

    Customer get(CustomerRequestId request);
}
