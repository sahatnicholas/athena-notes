package athena.common.error;

public interface ErrorCode {

  String getCode();

  String getCodePrefix();

  String getDefaultMessage();
}
