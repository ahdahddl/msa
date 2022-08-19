package per.msa.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "per.msa.notification",
                "per.msa.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "per.msa.clients"
)
public class ServiceMsaNotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMsaNotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return  args -> {
//            producer.publish(new Person("Ali", 18),
//                    notificationConfig.getInternalExchanges(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }


}
