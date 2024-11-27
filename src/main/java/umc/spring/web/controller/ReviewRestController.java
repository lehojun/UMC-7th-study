package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/write/{storeId}")
    public ApiResponse<ReviewResponseDTO.WriteResultDTO> Write(@RequestBody @Valid ReviewRequestDTO.WriteDTO request, @PathVariable Long storeId) {

        Review review = reviewCommandService.writeReview(request, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDTO(review));
    }
}
