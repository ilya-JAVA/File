package by.peretz.spring.validation;

import by.peretz.spring.domain.User;
import by.peretz.spring.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, User> {

  public final UserRepo userRepo;


  @Override
  public void initialize(UniqueEmail constraintAnnotation) {

  }

  @Override
  public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
    if(validUser(user)) {
      return true;
    } else {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(
          constraintValidatorContext.getDefaultConstraintMessageTemplate())
          .addPropertyNode("email").addConstraintViolation();
      return false;
    }
  }

  boolean validUser(User user) {
    if (user.getId() == null) {
      return userRepo.findByEmail(user.getEmail()) == null;
    } else {
      return user.getId().equals(userRepo.findByEmail(user.getEmail()).getId());
    }
  }
}
