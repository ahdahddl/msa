package per.msa.fraud.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.msa.fraud.service.FraudCheckService;

@RestController
@RequestMapping("msa/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudlentCustomer =
                fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudlentCustomer);

    }
}
