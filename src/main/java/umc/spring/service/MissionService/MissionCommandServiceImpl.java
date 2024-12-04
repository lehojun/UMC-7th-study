package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddDTO request) {
        Mission mission = MissionConverter.toMission(request);
        Long storeId = request.getStoreId();

        if(storeId != null) {
            Store foundStore = storeRepository.findById(storeId)
                    .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
            mission.setStore(foundStore);
        }

        return missionRepository.save(mission);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        return missionRepository.findAllByStore(store, PageRequest.of(page-1, 10));
    }

    @Override
    public Page<Mission> getMemberMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return memberMissionRepository.findMissionsByMember(member, MissionStatus.CHALLENGING, PageRequest.of(page-1,10));
    }
}
