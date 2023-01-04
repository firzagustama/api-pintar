package corp.bi.go.id.api.pintar.service.client.config;

import corp.bi.go.id.ap.khazanah.grpc.KhazanahServiceGrpc;
import corp.bi.go.id.ap.plugin.helper.MultiAddressNameResolverFactory;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class KhazanahClientServiceConfig {
    @Value("${khazanah.addresses}")
    private String addresses;

    @Bean(name = "khazanahChannel")
    public ManagedChannel khazanahChannel() {
        NameResolver.Factory nameResolverFactory = new MultiAddressNameResolverFactory(addresses);
        return ManagedChannelBuilder.forTarget("ap-khazanah")
                .nameResolverFactory(nameResolverFactory)
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .build();
    }

    @Bean(name = "khazanahBlockingStub")
    @Profile("!test")
    public KhazanahServiceGrpc.KhazanahServiceBlockingStub khazanahBlockingStub(ManagedChannel khazanahChannel) {
        return KhazanahServiceGrpc.newBlockingStub(khazanahChannel);
    }
}
