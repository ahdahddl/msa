package per.msa.licenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceMsaLicensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMsaLicensesApplication.class, args);
    }

}
