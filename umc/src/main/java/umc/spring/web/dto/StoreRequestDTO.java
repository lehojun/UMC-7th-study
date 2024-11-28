package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistChallenging;

import java.time.LocalDate;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO {
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Long regionId;
    }
    @Getter
    public static class AddMissionDTO {
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
    }


    @ExistChallenging
    @Getter
    public static class ChallengingMissionDTO {
        Long memberId;
        Long missionId;
    }
}
