package athena.authentication;

import athena.module.user.User;
import athena.module.user.UserMapper;
import athena.module.user.UserService;
import athena.module.user.model.UserRegistrationInput;

import athena.module.user.model.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder bcryptEncoder;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private SecurityContextHolderService<String> securityContextHolderService;

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.findOneByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    return user;
  }

  public UserRegistrationResponse save(UserRegistrationInput user) {
    User newUser = new User();
    newUser.setUsername(user.getUsername());
    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
    return userMapper.toResponse(userService.create(newUser));
  }

}
