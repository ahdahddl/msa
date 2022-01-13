package per.msa.licenses.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import per.msa.licenses.entity.License;

@Slf4j
@RestController
@RequestMapping(value = "msa/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @PostMapping
    public License registerLicenses(@RequestBody LicenseRegisterRequest request) {
        License license = License.builder()
                .organizationId(request.getLicense().getOrganizationId())
                .productName(request.getLicense().getProductName())
                .type(request.getLicense().getType())
                .build();
        log.info("New license registration {}", request);

        return license;
    }

    @GetMapping()
    public License getLicenses(
            @PathVariable Integer organizationId,
            @PathVariable Integer licenseId){
        return License.builder()
                .id(licenseId)
                .organizationId(organizationId)
                .productName("")
                .type("")
                .build();
    }


}
