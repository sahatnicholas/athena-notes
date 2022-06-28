package athena.module.user.model;

import athena.common.validation.password.Password;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegistrationInput {

  @NotNull
  private String username;

  @NotNull
  @Password
  private String password;

}
