package per.msa.licenses.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class License {

    private Integer id;
    private Integer organizationId;
    private String productName;
    private String type;

}
