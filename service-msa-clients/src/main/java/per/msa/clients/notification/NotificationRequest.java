package per.msa.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationRequest {

    private Integer toCustomerId;
    private String toCustomerName;
    private String message;
}
