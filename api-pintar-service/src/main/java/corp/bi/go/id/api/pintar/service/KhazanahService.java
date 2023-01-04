package corp.bi.go.id.api.pintar.service;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahResponse;

public interface KhazanahService {
    KhazanahResponse getKhazanah(String id);
}
