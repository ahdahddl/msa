package per.msa.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import per.msa.fraud.entity.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
