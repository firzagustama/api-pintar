package corp.bi.go.id.api.pintar.facade;

import corp.bi.go.id.ap.acquiring.grpc.OrderHeaderUBResponse;
import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.facade.response.ExchangeOrderUB;
import corp.bi.go.id.api.pintar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<ApiResponse<ExchangeOrderUB>> getExchangeOrderUB() {
        OrderHeaderUBResponse data = orderService.getOrderHeaderUB("ABCDEF");

        ExchangeOrderUB body = new ExchangeOrderUB();
        body.setId(data.getId());
        body.setOrderNo(data.getOrderNo());
        body.setName(data.getName());

        ApiResponse<ExchangeOrderUB> response = new ApiResponse<>();
        response.setResponseCode("1000");
        response.setResponseData(body);
        response.setResponseMessage("success");
        return ResponseEntity.ok(response);
    }
}
