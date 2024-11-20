//package umc.spring.repository.missionRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.Mission;
//import umc.spring.domain.mapping.MemberMission;
//import umc.spring.domain.enums.MissionStatus;
//import umc.spring.domain.mapping.QMemberMission;
//import umc.spring.domain.QMission;  // QMission 임포트 추가
//import umc.spring.domain.QStore;   // QStore 임포트 추가
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class MissionRepositoryImpl implements MissionRepositoryCustom {
//
//  private final JPAQueryFactory jpaQueryFactory;
//  private final QMemberMission memberMission = QMemberMission.memberMission;
//  private final QMission mission = QMission.mission;  // QMission 객체 추가
//  private final QStore store = QStore.store; // QStore 객체 추가
//
//  @Override
//  public Page<Mission> findMissionsByMemberAndStatus(Long memberId, MissionStatus status, Pageable pageable) {
//    BooleanBuilder predicate = new BooleanBuilder();
//
//    // 필터링 조건 설정: 멤버 ID와 미션 상태
//    predicate.and(memberMission.member.id.eq(memberId));
//    predicate.and(memberMission.status.eq(status));
//
//    // QueryDSL을 이용해 데이터 조회 후 페이징 처리
//    List<Mission> missions = jpaQueryFactory
//        .select(memberMission.mission)
//        .from(memberMission)
//        .where(predicate)
//        .offset(pageable.getOffset())
//        .limit(pageable.getPageSize())
//        .fetch();
//
//    // 총 개수 조회
//    long total = jpaQueryFactory.selectFrom(memberMission).where(predicate).fetchCount();
//
//    return new PageImpl<>(missions, pageable, total);
//  }
//
//  @Override
//  public Page<Mission> dynamicQueryWithBooleanBuilder(String regionName, Pageable pageable) {
//    BooleanBuilder predicate = new BooleanBuilder();
//
//    // 지역(regionName) 조건 추가
//    if (regionName != null && !regionName.isEmpty()) {
//      predicate.and(store.region.name.eq(regionName));  // region의 name을 기준으로 필터링
//    }
//
//    // QueryDSL을 이용해 미션 조회 후 페이징 처리
//    List<Mission> missions = jpaQueryFactory
//        .selectFrom(mission)  // QMission 사용
//        .leftJoin(mission.store, store)  // Store와 join하여 region을 가져옴
//        .where(predicate)
//        .offset(pageable.getOffset())
//        .limit(pageable.getPageSize())
//        .fetch();
//
//    // 총 개수 조회
//    long total = jpaQueryFactory.selectFrom(mission).leftJoin(mission.store, store).where(predicate).fetchCount();
//
//    return new PageImpl<>(missions, pageable, total);
//  }
//}
