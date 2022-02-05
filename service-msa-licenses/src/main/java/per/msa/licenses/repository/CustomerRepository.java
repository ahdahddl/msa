package per.msa.licenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import per.msa.licenses.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
