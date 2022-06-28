package athena.common.validation;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class BaseRegexStringValidator<T extends Annotation>
    implements ConstraintValidator<T, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }

    Matcher matcher = getPattern().matcher(value);
    return matcher.find();
  }

  public abstract Pattern getPattern();
}
