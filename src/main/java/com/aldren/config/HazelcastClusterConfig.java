package com.aldren.config;

import com.hazelcast.config.Config;
import com.hazelcast.eureka.one.EurekaOneDiscoveryStrategyFactory;
import com.netflix.discovery.EurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastClusterConfig {

    @Bean
    public Config hazelcastConfig(EurekaClient eurekaClient) {
        EurekaOneDiscoveryStrategyFactory.setEurekaClient(eurekaClient);
        Config config = new Config();
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getEurekaConfig()
                .setEnabled(true)
                .setProperty("self-registration", "true")
                .setProperty("namespace", "hazelcast")
                .setProperty("use-metadata-for-host-and-port", "true")
                .setProperty("skip-eureka-registration-verification", "true")
                .setProperty("use-classpath-eureka-client-props", "false")
                .setProperty("shouldUseDns", "false")
                .setProperty("name", "springboot-hazelcast")
                .setProperty("serviceUrl.default", "http://localhost:8761");
        return config;
    }

}
