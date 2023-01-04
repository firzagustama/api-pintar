package corp.bi.go.id.api.pintar.facade;

import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.facade.response.Khazanah;
import org.springframework.http.ResponseEntity;

public interface KhazanahFacade {
    ResponseEntity<ApiResponse<Khazanah>> getKhazanah(String id);
}
