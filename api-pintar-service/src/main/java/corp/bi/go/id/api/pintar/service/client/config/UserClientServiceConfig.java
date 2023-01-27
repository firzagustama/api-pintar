package corp.bi.go.id.api.pintar.service.client.config;

import corp.bi.go.id.ap.plugin.helper.MultiAddressNameResolverFactory;
import corp.bi.go.id.ap.user.grpc.CustomerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class UserClientServiceConfig {
    @Value("${user.addresses}")
    private String addresses;

    @Bean(name = "userChannel")
    public ManagedChannel userChannel() {
        NameResolver.Factory nameResolverFactory = new MultiAddressNameResolverFactory(addresses);
        return ManagedChannelBuilder.forTarget("ap-user")
                .nameResolverFactory(nameResolverFactory)
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .build();
    }

    @Bean(name = "customerBlockingStub")
    @Profile("!test")
    public CustomerServiceGrpc.CustomerServiceBlockingStub customerBlockingStub(ManagedChannel userChannel) {
        return CustomerServiceGrpc.newBlockingStub(userChannel);
    }
}
