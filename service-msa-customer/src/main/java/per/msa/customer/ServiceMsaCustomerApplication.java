package per.msa.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
    basePackages = "per.msa.clients"
)
public class ServiceMsaCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMsaCustomerApplication.class, args);
    }

}
