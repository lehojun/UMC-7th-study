package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    // 특정 지역에 가게 추가
    @PostMapping
    ApiResponse<?> addStore(@RequestBody StoreRequestDTO.AddStoreDTO request) {

        Store store = storeCommandService.addStore(request);

        return ApiResponse.onSuccess(null);
    }

    // 가게에 리뷰 추가
    @PostMapping("/reviews/stores/{storeId}")
    ApiResponse<?> addReview(@PathVariable Long storeId, @RequestBody ReviewRequestDTO.AddReviewDTO request) {

        Review review = storeCommandService.addReview(3L, storeId, request);

        return ApiResponse.onSuccess(null);
    }

    // 가게어 미션 추가
    @PostMapping("/missions/stores/{storeId}")
    ApiResponse<?> addMission(@PathVariable Long storeId, @RequestBody StoreRequestDTO.AddMissionDTO request) {

        Mission mission = storeCommandService.addMission(storeId, request);

        return ApiResponse.onSuccess(null);
    }

    // 가게에 미션을 도전중인 미션에 추가
    @PostMapping("/users/missions/{missionId}/challenge")
    ApiResponse<?> setMissionChallenging(@Valid @RequestBody StoreRequestDTO.ChallengingMissionDTO request) {

        MemberMission memberMission = storeCommandService.challengeMission(request);

        return ApiResponse.onSuccess(null);
    }
}
