package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;

public interface ReviewCommandService {
    public Review writeReview(ReviewRequestDTO.WriteDTO request, Long storeId);

}
