package per.msa.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import per.msa.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
