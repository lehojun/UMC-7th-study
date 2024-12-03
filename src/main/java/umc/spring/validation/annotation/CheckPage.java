package umc.spring.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PageCheckValidator;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션을 만들 때 붙인다.
@Constraint(validatedBy = PageCheckValidator.class) // 사용자가 validation을 커스텀 어노테이션을 통해 할 수 있도록 제공하는 어노테이션
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) //어노테이션의 적용 범위를 지정하는 역할
@Retention(RetentionPolicy.RUNTIME) //어노테이션의 생명 주기를 지정한다. 해당 코드는 실행하는 동안에만 유효.
public @interface CheckPage {
    String message() default "존재하지 않는 페이지 번호입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
