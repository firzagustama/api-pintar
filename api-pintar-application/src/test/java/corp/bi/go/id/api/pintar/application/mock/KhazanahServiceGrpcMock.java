package corp.bi.go.id.api.pintar.application.mock;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahRequest;
import corp.bi.go.id.ap.khazanah.grpc.KhazanahResponse;
import corp.bi.go.id.ap.khazanah.grpc.KhazanahServiceGrpc;
import corp.bi.go.id.ap.khazanah.grpc.UpdateOrderQuotaRequest;
import io.grpc.stub.StreamObserver;

public class KhazanahServiceGrpcMock extends KhazanahServiceGrpc.KhazanahServiceImplBase {
    public KhazanahServiceGrpcMock() {
        super();
    }

    @Override
    public void getKhazanah(KhazanahRequest request, StreamObserver<KhazanahResponse> responseObserver) {
        KhazanahResponse k = KhazanahResponse.newBuilder().setId(request.getId()).setType("Bank Indonesia").setName("KPw BI Sibolga").setAddress("JL. KAPTEN MARULI SITORUS NO.8, SIBOLGA").setOrderQuota(100).setStatus("Aktif").build();
        responseObserver.onNext(k);
        responseObserver.onCompleted();
    }

    @Override
    public void updateOrderQuota(UpdateOrderQuotaRequest request, StreamObserver<KhazanahResponse> responseObserver) {
        super.updateOrderQuota(request, responseObserver);
    }
}
