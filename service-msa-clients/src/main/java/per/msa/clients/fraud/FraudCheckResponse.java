package per.msa.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FraudCheckResponse {
    private boolean isFraudlentCustomer = false;
}
