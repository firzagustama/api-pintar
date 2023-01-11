package corp.bi.go.id.api.pintar.application.mock;

import corp.bi.go.id.ap.khazanah.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

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
    public void getAllKhazanah(AllKhazanahRequest request, StreamObserver<AllKhazanahResponse> responseObserver) {
        List<KhazanahResponse> khazanahList = new ArrayList<>();
        khazanahList.add(KhazanahResponse.newBuilder()
                .setId("0B503C70-6F78-4F44-A060-1A000D6CB0E6")
                .setType("Bank Indonesia")
                .setName("KPw BI Sibolga")
                .setAddress("JL. KAPTEN MARULI SITORUS NO.8, SIBOLGA")
                .setOrderQuota(100)
                .setStatus("Aktif")
                .build());
        khazanahList.add(KhazanahResponse.newBuilder()
                .setId("0CF2657B-5CAB-4D1D-BAFC-38C02B47F9C5")
                .setType("Bank Indonesia")
                .setName("KPw BI Prov. Jawa Tengah - Semarang")
                .setAddress("Jl. Imam Bardjo SH no.4")
                .setOrderQuota(100)
                .setStatus("Aktif")
                .build());
        khazanahList.add(KhazanahResponse.newBuilder()
                .setId("13E75146-6D30-4E9C-B88C-7BA945589D10")
                .setType("Bank Indonesia")
                .setName("KPw BI Cirebon")
                .setAddress("JL. YOS SUDARSO NO.5-7, CIREBON")
                .setOrderQuota(100)
                .setStatus("Aktif")
                .build());

        responseObserver.onNext(AllKhazanahResponse.newBuilder().addAllKhazanah(khazanahList).build());
        responseObserver.onCompleted();
    }

    @Override
    public void updateOrderQuota(UpdateOrderQuotaRequest request, StreamObserver<KhazanahResponse> responseObserver) {
        super.updateOrderQuota(request, responseObserver);
    }
}
