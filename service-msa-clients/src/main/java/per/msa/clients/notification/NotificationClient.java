package per.msa.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "service-msa-notification"
//        ,url = "${clients.notification.url}"
)
public interface NotificationClient {

    @PostMapping("msa/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}

