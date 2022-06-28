package athena.authentication;

import athena.common.constant.Constant;
import athena.common.exception.UnauthorizedException;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextHolderService<I> {

  public I getCurrentUserId() {
    return getCurrentUserIdOptional().orElseThrow(
        () -> new UnauthorizedException("User not logged in"));
  }

  private Optional<I> getCurrentUserIdOptional() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && !authentication.getName().equals(Constant.ANONYMOUS_USER)) {
      return Optional.of((I) authentication.getDetails());
    }
    return Optional.empty();
  }

}
