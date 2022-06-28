package athena.module.user;

import athena.common.base.entity.AuditableEntity;
import athena.common.constant.Constant;
import athena.common.contract.AuthenticatedUser;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.TypeDef;
import org.springframework.security.core.GrantedAuthority;

@Entity(name = "user_app")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends AuditableEntity implements AuthenticatedUser<String> {

  private String username;
  private String password;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> allAuthorities = new HashSet<>();
    return allAuthorities;
  }

  @Override
  public String getUsername() { return username; }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() { return true; }

  @Override
  public boolean isEnabled() {  return true; }

}
