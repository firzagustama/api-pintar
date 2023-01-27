package corp.bi.go.id.api.pintar.application.mock;

import corp.bi.go.id.ap.user.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceGrpcMock extends CustomerServiceGrpc.CustomerServiceImplBase {
    private final CustomerList customerList;

    public CustomerServiceGrpcMock() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.newBuilder().setId("111").setEmail("gilang.ramadhan@bi.go.id").setName("Gilang Ramadhan").build());
        customers.add(Customer.newBuilder().setId("112").setEmail("firza.gustama@bi.go.id").setName("Firza Gustama").build());
        customers.add(Customer.newBuilder().setId("113").setEmail("guna.wicaksana@bi.go.id").setName("Guna Wicaksana").build());

        customerList = CustomerList.newBuilder().addAllCustomers(customers).build();
    }

    @Override
    public void getAll(Empty request, StreamObserver<CustomerList> responseObserver) {
        responseObserver.onNext(customerList);
        responseObserver.onCompleted();
    }

    @Override
    public void get(CustomerRequestId request, StreamObserver<Customer> responseObserver) {
        responseObserver.onNext(customerList.getCustomers(1));
        responseObserver.onCompleted();
    }
}
