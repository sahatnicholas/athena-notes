package athena.module.user;

import athena.common.base.repository.BaseRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String> {

  User findOneByUsername(String username);

}
