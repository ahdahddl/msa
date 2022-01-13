package per.msa.licenses.web;

import lombok.Data;
import per.msa.licenses.entity.License;

@Data
public class LicenseRegisterRequest {

    private License license;
}
