package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.ChallengingExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChallengingExistValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistChallenging {

  String message() default "이미 진행중인 미션입니다.";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}