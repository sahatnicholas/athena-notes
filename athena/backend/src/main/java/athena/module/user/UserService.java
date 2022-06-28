package athena.module.user;

import athena.common.base.service.AthenaBaseServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserService extends AthenaBaseServiceImpl<User> {

  private final UserRepository repository;

  public UserService(UserRepository repository) {
    super(repository);
    this.repository = repository;
  }

  public User findOneByUsername(String username) {
    return repository.findOneByUsername(username);
  }

}
