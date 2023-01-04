package corp.bi.go.id.api.pintar.service.client.acquiring;

import corp.bi.go.id.ap.acquiring.grpc.OrderHeaderUBRequest;
import corp.bi.go.id.ap.acquiring.grpc.OrderHeaderUBResponse;
import corp.bi.go.id.ap.acquiring.grpc.OrderServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderClientService {
    @Autowired
    private OrderServiceGrpc.OrderServiceBlockingStub orderBlockingStub;

    public OrderHeaderUBResponse getOrderUB(OrderHeaderUBRequest request) {
        return orderBlockingStub.getOrderUB(request);
    }
}
