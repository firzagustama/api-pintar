package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.acquiring.grpc.OrderHeaderUBRequest;
import corp.bi.go.id.ap.acquiring.grpc.OrderHeaderUBResponse;
import corp.bi.go.id.api.pintar.service.client.acquiring.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderClientService orderClientService;

    public OrderHeaderUBResponse getOrderHeaderUB(String orderNo) {
        OrderHeaderUBResponse response = orderClientService.getOrderUB(OrderHeaderUBRequest.newBuilder()
                .setOrderNo(orderNo)
                .build());
        return response;
    }
}
