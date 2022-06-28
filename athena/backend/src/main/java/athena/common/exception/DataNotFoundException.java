package athena.common.exception;

import athena.common.error.CommonErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeExceptionWithErrorCode {

  private static final long serialVersionUID = -1131142450229861600L;

  public DataNotFoundException() {
    super(CommonErrorCode.DATA_NOT_FOUND, "Entity", "");
  }

  public DataNotFoundException(Class classNotFound) {
    super(CommonErrorCode.DATA_NOT_FOUND, classNotFound.getName(), "");
  }

  public DataNotFoundException(Class classNotFound, String reason) {
    super(CommonErrorCode.DATA_NOT_FOUND, classNotFound.getName(), reason);
  }
}
