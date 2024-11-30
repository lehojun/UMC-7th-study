package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface MissionCommandService {
    public Mission addMission(MissionRequestDTO.AddDTO request);

}
