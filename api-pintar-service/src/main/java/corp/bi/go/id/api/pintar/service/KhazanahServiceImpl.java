package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahResponse;
import corp.bi.go.id.api.pintar.service.client.khazanah.KhazanahClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhazanahServiceImpl implements KhazanahService{
    @Autowired
    private KhazanahClientService khazanahClientService;

    @Override
    public KhazanahResponse getKhazanah(String id) {
        return khazanahClientService.getKhazanah(id);
    }
}
