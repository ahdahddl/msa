package per.msa.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import per.msa.customer.entity.Customer;
import per.msa.customer.repository.CustomerRepository;
import per.msa.customer.web.CustomerRegistrationRequest;
import per.msa.customer.web.FraudCheckResponse;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://service-msa-fraud/msa/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudlentCustomer()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
