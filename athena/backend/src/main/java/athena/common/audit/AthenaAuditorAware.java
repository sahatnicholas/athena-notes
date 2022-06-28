package athena.common.audit;

import athena.common.constant.Constant;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AthenaAuditorAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String name = authentication == null
        || authentication.getName().equals(Constant.ANONYMOUS_USER)
        ? Constant.SYSTEM_USERNAME : authentication.getName();
    return Optional.of(name);
  }

}
