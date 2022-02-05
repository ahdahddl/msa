package per.msa.licenses.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import per.msa.licenses.service.CustomerService;

@Slf4j
@RestController
@RequestMapping("msa/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getDefaultCustomerString")
    public String getDefaultCustomerString() {
        return "default customer";
    }

    @PostMapping("/registerCustomer")
    public CustomerRegistrationRequest registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
        return customerRequest;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    static class AccessDeniedException extends RuntimeException {

    }
}
