package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.AddDTO request) {

        return Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .build();
    }

    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission) {
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
