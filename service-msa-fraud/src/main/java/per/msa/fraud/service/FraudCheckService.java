package per.msa.fraud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import per.msa.fraud.entity.FraudCheckHistory;
import per.msa.fraud.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
