package per.msa.modulesecurity.auth;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import per.msa.modulesecurity.security.ApplicationUserRole;

import java.util.List;
import java.util.Optional;

@Repository("fake")
@AllArgsConstructor
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        ApplicationUserRole.STUDENT.getGrantedAuthorities(),
                        "annasmith",
                        passwordEncoder.encode("password"),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                        "linda",
                        passwordEncoder.encode("password123"),
                        true,
                        true,
                        true,
                        true
                ), new ApplicationUser(
                        ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("password123"),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
