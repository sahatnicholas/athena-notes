package athena.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {

  private static final long serialVersionUID = 4095779956172537665L;

  public UnauthorizedException(String message) {
    super(message);
  }
}
