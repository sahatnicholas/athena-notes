package athena.common.validation.password;

import athena.common.validation.BaseRegexStringValidator;
import java.util.regex.Pattern;

/**
 * PasswordValidator
 * Copyright (c) 2020 GLAIR. All rights reserved.
 *
 * @author RaisaAnjani
 * @since Apr 22, 2020.
 **/
public class PasswordValidator extends BaseRegexStringValidator<Password> {

  private static final Pattern PATTERN =
      Pattern.compile("[a-zA-Z0-9~!@#$%^&*()`\\-={}\\[\\]\\\\\\|:;\"'<>?/,.]{8,20}$");

  @Override
  public Pattern getPattern() {
    return PATTERN;
  }
}
