package athena.common.exception;

import athena.common.error.ErrorCode;

public class RuntimeExceptionWithErrorCode extends RuntimeException {

  private static final long serialVersionUID = 7341864239538327695L;

  private final ErrorCode errorCode;

  public RuntimeExceptionWithErrorCode(ErrorCode errorCode) {
    super(errorCode.getDefaultMessage());
    this.errorCode = errorCode;
  }

  public RuntimeExceptionWithErrorCode(ErrorCode errorCode, Object... args) {
    super(String.format(errorCode.getDefaultMessage(), args));
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
