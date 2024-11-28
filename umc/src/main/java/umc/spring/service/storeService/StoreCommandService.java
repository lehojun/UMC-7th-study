package umc.spring.service.storeService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store addStore(StoreRequestDTO.AddStoreDTO request);
    Review addReview(Long memberId, Long storeId, ReviewRequestDTO.AddReviewDTO request);
    Mission addMission(Long storeId, StoreRequestDTO.AddMissionDTO request);
    MemberMission challengeMission(StoreRequestDTO.ChallengingMissionDTO request);
}
