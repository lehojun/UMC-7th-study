package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;

public interface MemberCommandService {
  Member joinMember(MemberRequestDTO.JoinDTO request);
  MissionStatus getMissionStatus(StoreRequestDTO.ChallengingMissionDTO request);
}