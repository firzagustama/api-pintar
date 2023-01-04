package corp.bi.go.id.api.pintar.facade;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahResponse;
import corp.bi.go.id.ap.plugin.facade.response.ApiResponse;
import corp.bi.go.id.api.pintar.facade.response.Khazanah;
import corp.bi.go.id.api.pintar.service.KhazanahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("khazanah")
public class KhazanahFacadeImpl implements KhazanahFacade {
    @Autowired
    private KhazanahService khazanahService;

    @GetMapping
    public ResponseEntity<ApiResponse<Khazanah>> getKhazanah(@RequestParam String id) {
        KhazanahResponse data = khazanahService.getKhazanah(id);

        Khazanah body = new Khazanah();
        body.setId(data.getId());
        body.setType(data.getType());
        body.setName(data.getName());
        body.setAddress(data.getAddress());
        body.setOrderQuota(data.getOrderQuota());
        body.setStatus(data.getStatus());

        ApiResponse<Khazanah> response = new ApiResponse<>();
        response.setResponseCode("1000");
        response.setResponseMessage("success");
        response.setResponseData(body);
        return ResponseEntity.ok(response);
    }
}
