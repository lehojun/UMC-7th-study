package umc.spring.repository.missionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MissionRepositoryImpl implements MissionRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  private final QMission mission = QMission.mission;
  private final QStore store = QStore.store;
  private final QRegion region = QRegion.region;
  private final QMemberMission memberMission = QMemberMission.memberMission;

  @Override
  public List<Mission> findAvailableMissionsByRegion(String regionName, Long memberId, Long cursorId, int limit) {

    BooleanBuilder predicate = new BooleanBuilder();



    if (regionName != null) {
      predicate.and(region.name.eq(regionName));
    }

    if (memberId != null) {
      predicate.and(mission.id.notIn(
          JPAExpressions
              .select(memberMission.mission.id)
              .from(memberMission)
              .where(memberMission.member.id.eq(memberId))
      ));
    }

    if (cursorId != null) {
      predicate.and(mission.id.lt(cursorId));
    }

    predicate.and(mission.deadline.gt(LocalDate.now()));

    return jpaQueryFactory
        .selectFrom(mission)
        .join(mission.store, store).fetchJoin()
        .join(store.region, region).fetchJoin()
        .where(predicate)
        .orderBy(mission.id.desc())
        .limit(limit)
        .fetch();
  }

  @Override
  public List<Tuple> findMissionsByMemberIdAndStatus(Long memberId, Long cursor, int limit, MissionStatus status) {
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