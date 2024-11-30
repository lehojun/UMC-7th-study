package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMissionConverter(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
