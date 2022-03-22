package per.msa.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import per.msa.clients.notification.NotificationRequest;
import per.msa.notification.entity.Notification;
import per.msa.notification.repository.NotificationRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerName())
                        .sender("Amigoscode")
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
