package umc.spring.repository.missionRepository;

import com.querydsl.core.Tuple;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {

  List<Mission> findAvailableMissionsByRegion(String regionName, Long memberId, Long cursorId, int limit);
  List<Tuple> findMissionsByMemberIdAndStatus(Long memberId, Long cursor, int limit, MissionStatus status);

}