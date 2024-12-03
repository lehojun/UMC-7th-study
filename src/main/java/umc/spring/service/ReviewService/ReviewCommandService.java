package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;

public interface ReviewCommandService {
     Review writeReview(ReviewRequestDTO.WriteDTO request, Long storeId);
     Page<Review> getReviewList(Long memberId, Integer page);
}
