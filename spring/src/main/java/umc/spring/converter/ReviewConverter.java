package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.web.dto.ReviewRequestDTO;

import java.util.ArrayList;

public class ReviewConverter {

  public static Review toReview(ReviewRequestDTO.AddReviewDTO request) {

    return Review.builder()
        .score(request.getScore())
        .body(request.getBody())
        .reviewImageList(new ArrayList<>())
        .build();
  }

  public static ReviewImage toReviewImage(ReviewRequestDTO.AddReviewImageDTO request) {

    return ReviewImage.builder()
        .url(request.getUrl())
        .build();
  }
}