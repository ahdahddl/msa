package per.msa.fraud.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.msa.fraud.entity.FraudCheckHistory;
import per.msa.fraud.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Slf4j
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
        log.info(customerId.toString());
        return false;
    }
}
