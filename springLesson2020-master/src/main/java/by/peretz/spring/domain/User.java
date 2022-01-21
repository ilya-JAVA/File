package by.peretz.spring.domain;

import by.peretz.spring.validation.PasswordConfirm;
import by.peretz.spring.validation.UniqueEmail;
import by.peretz.spring.validation.UniqueUsername;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@UniqueEmail(message = "email существует")
@UniqueUsername(message = "Логин существует")
@PasswordConfirm(message = "Пароль не совпадает")
public class User extends AbstractEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  @Transient
  private String passwordConfirm;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String surname;

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  private Set<Role> roles;

  @Email
  @NotBlank
  private String email;

  @OneToMany(mappedBy = "carOwner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Car> userCars;

  private String activationCode;

  private boolean isActive;

  public boolean isAdmin() {
    return roles.contains(Role.ADMIN);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return isActive;
  }

  @Override
  public void save(Car car) {

  }
}
