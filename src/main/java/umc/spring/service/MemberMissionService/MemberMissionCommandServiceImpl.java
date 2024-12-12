package umc.spring.service.MemberMissionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission joinMission(MemberMissionRequestDTO.JoinDTO request) {

            Member member = memberRepository.findById(request.getMemberId())
                    .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
            Mission mission = missionRepository.findById(request.getMissionId())
                    .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

            MemberMission memberMission = MemberMissionConverter.toMemberMissionConverter(member, mission);
        return memberMissionRepository.save(memberMission);
    }


        @Override
        public MissionStatus findMemberIdAndMissionId (MemberMissionRequestDTO.JoinDTO request){
        Long missionId = request.getMissionId();
        Long memberId = request.getMemberId();

        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId);

        if(memberMission == null) return MissionStatus.NONE;
        return memberMission.getStatus();
        }

    @Override
    public MemberMission changeMissionStatus(Long memberMissionId) {

        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));

        if(memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_ALREADY_COMPLETED);
        }

            memberMission.setStatus(MissionStatus.COMPLETE);
        return memberMissionRepository.save(memberMission);
    }
}
