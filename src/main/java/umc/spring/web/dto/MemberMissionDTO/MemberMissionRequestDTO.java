package umc.spring.web.dto.MemberMissionDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistMemberMission;

public class MemberMissionRequestDTO {
    @ExistMemberMission
    @Getter
    public static class JoinDTO {
        @NotNull
        Long memberId;

        @NotNull
        Long missionId;
    }
}
