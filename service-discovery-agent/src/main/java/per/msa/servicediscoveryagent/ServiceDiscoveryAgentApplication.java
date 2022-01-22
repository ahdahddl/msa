package per.msa.servicediscoveryagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryAgentApplication {

    public static void main(String[] args) {
//        new SpringApplicationBuilder(ServiceDiscoveryAgentApplication.class).web(true).run(args);
//        SpringApplication.run(ServiceDiscoveryAgentApplication.class, args);
    }

}
