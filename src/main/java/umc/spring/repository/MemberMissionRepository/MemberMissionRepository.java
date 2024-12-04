package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;


public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    MemberMission findByMemberIdAndMissionId(Long memberId, Long missionId);

    @Query("SELECT m FROM MemberMission mm JOIN mm.mission m WHERE mm.member = :member AND mm.status = :status")
    Page<Mission> findMissionsByMember(@Param("member")Member member, @Param("status")MissionStatus status, PageRequest pageRequest);
}
