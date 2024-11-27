package umc.spring.web.dto.MissionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MissionRequestDTO {

    @Getter
    public static class AddDTO {
        @NotNull
        Long storeId;

        @NotNull
        String missionSpec;

        @NotNull
        int reward;

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate deadline;
    }
}
