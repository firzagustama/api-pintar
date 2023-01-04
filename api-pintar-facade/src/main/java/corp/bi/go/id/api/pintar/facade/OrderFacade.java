package corp.bi.go.id.api.pintar.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.facade.response.ExchangeOrderUB;
import org.springframework.http.ResponseEntity;

public interface OrderFacade {

    ResponseEntity<ApiResponse<ExchangeOrderUB>> getExchangeOrderUB();
}
