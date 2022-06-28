package athena.common.validation.password;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {

  String message() default "Invalid password. "
      + "Use 8-20 characters with a mix of letters, numbers or symbols.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
