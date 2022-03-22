package per.msa.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import per.msa.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
