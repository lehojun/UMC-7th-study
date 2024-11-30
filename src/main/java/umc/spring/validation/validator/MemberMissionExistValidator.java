package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.FoodCategoryService.FoodCategoryCommandService;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.controller.MissionRestController;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission,MemberMissionRequestDTO.JoinDTO> {

    private final MemberMissionCommandService memberMissionCommandService;

    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.JoinDTO request, ConstraintValidatorContext context) {

        boolean isValid = !memberMissionCommandService.findMemberIdAndMissionId(request).equals(MissionStatus.CHALLENGING);

        if(!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.EXIST_MEMBER_MISSION_ID.toString()).addConstraintViolation();
        }
        return isValid;
    }


}
