package umc.spring.repository.memberRepository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Tuple> findMissionsByMemberIdAndStatus(Long memberId, Long cursor, int limit, MissionStatus status) {
        {
            return jpaQueryFactory
                    .select(QMission.mission.id, QStore.store.name, QMission.mission.reward, QMission.mission.missionSpec, QMemberMission.memberMission.status)
                    .from(QMember.member)
                    .join(QMember.member.memberMissionList, QMemberMission.memberMission)
                    .join(QMemberMission.memberMission.mission, QMission.mission)
                    .join(QMission.mission.store, QStore.store)
                    .where(
                            QMember.member.id.eq(memberId),
                            QMemberMission.memberMission.status.eq(status),
                            QMission.mission.id.lt(cursor)
                    )
                    .orderBy(QMission.mission.id.desc())
                    .limit(limit)
                    .fetch();
        }
    }

    @Override
    public List<Tuple> findAvailableMissionsByRegion(String regionName, Long memberId, Long cursorId, int limit) {

        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;
        QMemberMission memberMission = QMemberMission.memberMission;

        return jpaQueryFactory
                .select(
                        mission.id,
                        store.name,
                        mission.reward,
                        mission.missionSpec,
                        Expressions.numberTemplate(Integer.class, "DATEDIFF({0}, {1})", mission.deadline, LocalDate.now()).as("days_left")
                )
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                        region.name.eq(regionName),
                        mission.deadline.gt(LocalDate.now()),
                        mission.id.lt(cursorId),
                        mission.id.notIn(
                                JPAExpressions
                                        .select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(memberId))
                        )
                )
                .orderBy(mission.id.desc())
                .limit(limit)
                .fetch();
    }

    @Override
    public Tuple findMemberById(Long memberId) {
        {
            QMember member = QMember.member;

            return jpaQueryFactory
                    .select(
                            member.id,
                            member.name,
                            member.email,
                            member.phoneNum,
                            member.point
                    )
                    .from(member)
                    .where(member.id.eq(memberId))
                    .fetchOne();
        }
    }
}
