package umc.spring.repository.memberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Optional<MemberMission> findMemberMissionByMissionIdAndMemberId(Long missionId, Long memberId);
}
