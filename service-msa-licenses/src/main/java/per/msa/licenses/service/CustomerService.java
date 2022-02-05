package per.msa.licenses.service;

import org.springframework.stereotype.Service;
import per.msa.licenses.entity.Customer;
import per.msa.licenses.repository.CustomerRepository;
import per.msa.licenses.web.CustomerRegistrationRequest;

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
