package umc.spring.repository.memberRepository;

import com.querydsl.core.Tuple;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.util.List;

public interface MemberRepositoryCustom {

    public List<Tuple> findMissionsByMemberIdAndStatus(Long memberId, Long cursor, int limit, MissionStatus status);
    public List<Tuple> findAvailableMissionsByRegion(String regionName, Long memberId, Long cursorId, int limit);
    public Tuple findMemberById(Long memberId);
}
