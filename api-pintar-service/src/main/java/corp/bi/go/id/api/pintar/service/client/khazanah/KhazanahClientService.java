package corp.bi.go.id.api.pintar.service.client.khazanah;

import corp.bi.go.id.ap.khazanah.grpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhazanahClientService {
    @Autowired
    private KhazanahServiceGrpc.KhazanahServiceBlockingStub khazanahBlockingStub;

    public KhazanahResponse getKhazanah(String id) {
        return khazanahBlockingStub.getKhazanah(KhazanahRequest.newBuilder()
                .setId(id)
                .build());
    }

    public AllKhazanahResponse getAllKhazanah() {
        return khazanahBlockingStub.getAllKhazanah(AllKhazanahRequest.newBuilder().build());
    }
}
