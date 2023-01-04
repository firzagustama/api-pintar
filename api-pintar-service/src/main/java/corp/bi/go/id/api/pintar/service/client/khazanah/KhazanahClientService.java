package corp.bi.go.id.api.pintar.service.client.khazanah;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahRequest;
import corp.bi.go.id.ap.khazanah.grpc.KhazanahResponse;
import corp.bi.go.id.ap.khazanah.grpc.KhazanahServiceGrpc;
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
}
