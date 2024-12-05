package umc.spring.service.MemberMissionService;

import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission joinMission(MemberMissionRequestDTO.JoinDTO request);
    MissionStatus findMemberIdAndMissionId(MemberMissionRequestDTO.JoinDTO request);
    MemberMission changeMissionStatus(Long memberMissionId);
}
