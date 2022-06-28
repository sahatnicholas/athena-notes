package athena.common.contract;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticatedUser<I> extends UserDetails {
  I getId();
}
