package per.msa.modulesecurity.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;


}
