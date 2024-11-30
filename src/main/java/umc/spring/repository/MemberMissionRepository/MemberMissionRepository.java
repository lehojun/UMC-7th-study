package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    MemberMission findByMemberIdAndMissionId(Long memberId, Long missionId);
}
