package corp.bi.go.id.api.pintar.application.config;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahServiceGrpc;
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
public class KhazanahFacadeTestConfig {

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
    private final String serverName = InProcessServerBuilder.generateName();

    @Bean(name = "khazanahBlockingStub")
    @Primary
    public KhazanahServiceGrpc.KhazanahServiceBlockingStub khazanahBlockingStub() throws IOException {
        // Create a server, add service, start, and register for automatic graceful shutdown.
        grpcCleanup.register(InProcessServerBuilder.forName(serverName).directExecutor().addService(new KhazanahServiceGrpcMock()).build().start());

        // Create a client channel and register for automatic graceful shutdown.
        return KhazanahServiceGrpc.newBlockingStub(grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));
    }
}
