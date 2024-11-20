//package umc.spring.repository.missionRepository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import umc.spring.domain.Mission;
//import umc.spring.domain.enums.MissionStatus;
//
//public interface MissionRepositoryCustom {
//  Page<Mission> findMissionsByMemberAndStatus(Long memberId, MissionStatus status, Pageable pageable);
//  Page<Mission> dynamicQueryWithBooleanBuilder(String location, Pageable pageable);
//}
