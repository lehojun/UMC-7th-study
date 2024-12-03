package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO.AddDTO request);
    Page<Mission> getMissionList(Long memberId, Integer page);

}
