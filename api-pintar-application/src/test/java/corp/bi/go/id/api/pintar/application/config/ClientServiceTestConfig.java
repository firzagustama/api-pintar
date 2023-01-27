package corp.bi.go.id.api.pintar.application.config;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahServiceGrpc;
import corp.bi.go.id.ap.user.grpc.CustomerServiceGrpc;
import corp.bi.go.id.api.pintar.application.mock.CustomerServiceGrpcMock;
import corp.bi.go.id.api.pintar.application.mock.KhazanahServiceGrpcMock;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.io.IOException;

@TestConfiguration
public class ClientServiceTestConfig {

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
    private final String serverName = InProcessServerBuilder.generateName();

    public ClientServiceTestConfig() throws IOException {
        grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor().addService(new KhazanahServiceGrpcMock()).addService(new CustomerServiceGrpcMock()).build().start());
    }

    @Bean(name = "khazanahBlockingStub")
    @Primary
    public KhazanahServiceGrpc.KhazanahServiceBlockingStub khazanahBlockingStub() {
        return KhazanahServiceGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
    }

    @Bean(name = "customerBlockingStub")
    @Primary
    public CustomerServiceGrpc.CustomerServiceBlockingStub customerBlockingStub() {
        return CustomerServiceGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
    }
}
