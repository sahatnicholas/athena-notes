package athena.common.error;

public enum CommonErrorCode implements ErrorCode {

  GENERAL("Unexpected error has occurred"),
  DATA_NOT_FOUND("%s %s not found"),
  DATA_EXISTS("%s %s already exist"),
  NOT_IMPLEMENTED("%s is not yet implemented");

  private final String defaultMessage;

  CommonErrorCode(String defaultMessage) {
    this.defaultMessage = defaultMessage;
  }

  @Override
  public String getCode() {
    return getCodePrefix() + name();
  }

  @Override
  public String getCodePrefix() {
    return "ERROR_";
  }

  @Override
  public String getDefaultMessage() {
    return defaultMessage;
  }
}
