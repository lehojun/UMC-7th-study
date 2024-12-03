package umc.spring.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class WriteDTO {
        @NotNull
        Long memberId;

        @NotNull
        float score;

        @NotNull
        String title;
    }
}
