package by.peretz.spring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConfirmValidator.class)
public @interface PasswordConfirm {
  String message() default "Password confirm isn't correct";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
