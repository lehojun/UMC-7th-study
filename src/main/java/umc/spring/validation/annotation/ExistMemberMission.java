package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberMissionExistValidator;
import umc.spring.validation.validator.RegionExistValidator;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션을 만들 때 붙인다.
@Constraint(validatedBy = MemberMissionExistValidator.class) // 사용자가 validation을 커스텀 어노테이션을 통해 할 수 있도록 제공하는 어노테이션
@Target({ ElementType.TYPE}) //어노테이션의 적용 범위를 지정하는 역할
@Retention(RetentionPolicy.RUNTIME) //어노테이션의 생명 주기를 지정한다. 해당 코드는 실행하는 동안에만 유효.
public @interface ExistMemberMission {

    String message() default "이미 도전중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
