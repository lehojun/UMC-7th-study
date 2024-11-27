package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.WriteDTO request, Long storeId) {

        return Review.builder()
                .score(request.getScore())
                .title(request.getTitle())
                .build();
    }

    public static ReviewResponseDTO.WriteResultDTO toWriteResultDTO(Review review) {
        return ReviewResponseDTO.WriteResultDTO.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
