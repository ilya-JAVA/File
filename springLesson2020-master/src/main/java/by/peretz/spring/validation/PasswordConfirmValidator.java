package by.peretz.spring.validation;

import by.peretz.spring.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirm, User> {

  @Override
  public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
    if (user.getPassword().equals(user.getPasswordConfirm())){
      return true;
    } else {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate(
          constraintValidatorContext.getDefaultConstraintMessageTemplate())
          .addPropertyNode("passwordConfirm").addConstraintViolation();
      return false;
    }
  }

  @Override
  public void initialize(PasswordConfirm constraintAnnotation) {

  }
}
