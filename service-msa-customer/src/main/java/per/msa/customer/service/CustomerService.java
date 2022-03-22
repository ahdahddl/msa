package per.msa.customer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import per.msa.clients.fraud.FraudCheckResponse;
import per.msa.clients.fraud.FraudClient;
import per.msa.customer.entity.Customer;
import per.msa.customer.repository.CustomerRepository;
import per.msa.customer.web.CustomerRegistrationRequest;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        // 1. openfeign 에 의해 2번으로 이동
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://service-msa-fraud/msa/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );

        log.info(customer.getId().toString());
        // 2. openfeign 을 통해 client 를 이용
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudlentCustomer()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
