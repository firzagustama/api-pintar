package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.acquiring.grpc.OrderHeaderUBResponse;

public interface OrderService {
    OrderHeaderUBResponse getOrderHeaderUB(String orderNo);
}
