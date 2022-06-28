package athena.common.exception;

import athena.common.error.CommonErrorCode;

public class DataExistsException extends RuntimeExceptionWithErrorCode {

  private static final long serialVersionUID = -9025366369444957597L;

  public DataExistsException() {
    super(CommonErrorCode.DATA_EXISTS, "Entity", "");
  }

  public DataExistsException(Class classExists) {
    super(CommonErrorCode.DATA_EXISTS, classExists.getName(), "");
  }

  public DataExistsException(Class classExists, String reason) {
    super(CommonErrorCode.DATA_EXISTS, classExists.getName(), reason);
  }
}
