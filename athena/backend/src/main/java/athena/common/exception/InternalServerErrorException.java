package athena.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

  private static final long serialVersionUID = 9221064585955181996L;

  public InternalServerErrorException(String message) {
    super(message);
  }

  public InternalServerErrorException(String message, Exception exception) {
    super(message, exception);
  }

  public InternalServerErrorException(Throwable cause) {
    super(cause);
  }
}
