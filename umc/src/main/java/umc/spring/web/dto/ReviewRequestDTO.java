package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDTO {
        @NotBlank
        String body;
        @NotNull
        Float score;
        List<AddReviewImageDTO> reviewImages;
    }

    @Getter
    public static class AddReviewImageDTO {
        String url;
    }
}
