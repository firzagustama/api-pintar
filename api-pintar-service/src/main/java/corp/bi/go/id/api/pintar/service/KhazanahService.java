package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahResponse;

import java.util.List;

public interface KhazanahService {
    KhazanahResponse getKhazanah(String id);

    List<KhazanahResponse> getAllKhazanah();
}
