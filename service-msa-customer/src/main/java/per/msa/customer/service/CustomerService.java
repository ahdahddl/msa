package per.msa.customer.service;

import org.springframework.stereotype.Service;
import per.msa.customer.entity.Customer;
import per.msa.customer.repository.CustomerRepository;
import per.msa.customer.web.CustomerRegistrationRequest;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.save(customer);
    }
}
