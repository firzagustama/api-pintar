package corp.bi.go.id.api.pintar.service.client.config;

import corp.bi.go.id.ap.acquiring.grpc.OrderServiceGrpc;
import corp.bi.go.id.ap.plugin.helper.MultiAddressNameResolverFactory;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcquiringClientServiceConfig {

    @Value("${acquiring.addresses}")
    private String addresses;

    @Bean(name = "acquiringChannel")
    public ManagedChannel acquiringChannel() {
        NameResolver.Factory nameResolverFactory = new MultiAddressNameResolverFactory(addresses);
        return ManagedChannelBuilder.forTarget("ap-acquiring").nameResolverFactory(nameResolverFactory).defaultLoadBalancingPolicy("round_robin").usePlaintext().build();
    }

    @Bean(name = "orderBlockingStub")
    public OrderServiceGrpc.OrderServiceBlockingStub orderBlockingStub(ManagedChannel acquiringChannel) {
        return OrderServiceGrpc.newBlockingStub(acquiringChannel);
    }
}
