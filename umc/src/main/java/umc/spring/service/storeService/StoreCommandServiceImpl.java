package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.*;
import umc.spring.repository.regionRepository.RegionRepository;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.memberMissionRepository.MemberMissionRepository;
import umc.spring.repository.memberRepository.MemberRepository;
import umc.spring.repository.missionRepository.MissionRepository;
import umc.spring.repository.storeRepository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    public Store addStore(StoreRequestDTO.AddStoreDTO request) {

        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(()->
                new StoreHandler(ErrorStatus.REGION_NOT_FOUND));
        Store store = StoreConverter.toStore(request);

        store.setRegion(region);
        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Review addReview(Long memberId, Long storeId, ReviewRequestDTO.AddReviewDTO request) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = ReviewConverter.toReview(request);
        review.setMember(member);
        review.setStore(store);

        if (request.getReviewImages() == null) {

            return reviewRepository.save(review);
        }

        List<ReviewImage> reviewImageList = request.getReviewImages().stream()
                .map(imageDTO -> {
                    ReviewImage reviewImage = ReviewConverter.toReviewImage(imageDTO);
                    reviewImage.setReview(review);
                    return reviewImage;
                }).toList();

        review.setReviewImageList(reviewImageList);

        reviewRepository.save(review);
        reviewImageRepository.saveAll(reviewImageList);

        return review;
    }

    @Override
    public Mission addMission(Long storeId, StoreRequestDTO.AddMissionDTO request) {

        Store store = storeRepository.findById(storeId).orElseThrow(() ->
                new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = MissionConverter.toMission(request, store);

        return missionRepository.save(mission);
    }

    @Override
    public MemberMission challengeMission(StoreRequestDTO.ChallengingMissionDTO request) {

        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();

        memberMission.setMission(missionRepository.findById(request.getMissionId()).orElseThrow(() ->
                new StoreHandler(ErrorStatus.MISSION_NOT_FOUND)));
        memberMission.setMember(memberRepository.findById(request.getMemberId()).orElseThrow(() ->
                new StoreHandler(ErrorStatus.MEMBER_NOT_FOUND)));

        return memberMissionRepository.save(memberMission);
    }
}
