package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.memberService.MemberCommandService;
import umc.spring.validation.annotation.ExistChallenging;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChallengingExistValidator implements ConstraintValidator<ExistChallenging, StoreRequestDTO.ChallengingMissionDTO> {

  private final MemberCommandService memberCommandService;

  @Override
  public boolean isValid(StoreRequestDTO.ChallengingMissionDTO value, ConstraintValidatorContext context) {

    boolean isValid = memberCommandService.getMissionStatus(value).equals(MissionStatus.CHALLENGING);
    System.out.println(isValid);

    if (isValid) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();;
    }

    return isValid;
  }
}