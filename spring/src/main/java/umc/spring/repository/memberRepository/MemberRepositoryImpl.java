//package umc.spring.repository.memberRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.Member;
//import umc.spring.domain.Mission;
//import umc.spring.domain.QReview;
//import umc.spring.domain.Review;
//import umc.spring.domain.Store;
//import umc.spring.domain.mapping.MemberMission;
//import umc.spring.domain.QMember;
//import umc.spring.domain.mapping.QMemberMission;
//import umc.spring.domain.QMission;
//import umc.spring.domain.QStore;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepositoryImpl implements MemberRepositoryCustom {
//
//  private final JPAQueryFactory jpaQueryFactory;
//  private final QMember member = QMember.member;
//  private final QMemberMission memberMission = QMemberMission.memberMission;
//  private final QMission mission = QMission.mission;
//  private final QStore store = QStore.store;
//  private final QReview review = QReview.review;
//
//  // 사용자가 참여한 미션과 관련된 정보 조회 (진행 중/완료된 미션)
//  @Override
//  public Page<Mission> getMemberMissions(Long memberId, Pageable pageable) {
//    BooleanBuilder predicate = new BooleanBuilder();
//    predicate.and(memberMission.member.id.eq(memberId));  // 사용자 ID 필터링
//
//    // QueryDSL을 이용해 미션 조회 후 페이징 처리
//    List<Mission> missions = jpaQueryFactory
//        .select(memberMission.mission)
//        .from(memberMission)
//        .leftJoin(memberMission.mission, mission)  // 미션과 조인
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
//  // 사용자가 작성한 리뷰 조회
//  @Override
//  public Page<Review> getMemberReviews(Long memberId, Pageable pageable) {
//    BooleanBuilder predicate = new BooleanBuilder();
//    predicate.and(review.member.id.eq(memberId));  // 사용자 ID 필터링
//
//    // QueryDSL을 이용해 리뷰 조회 후 페이징 처리
//    List<Review> reviews = jpaQueryFactory
//        .selectFrom(review)
//        .where(predicate)
//        .offset(pageable.getOffset())
//        .limit(pageable.getPageSize())
//        .fetch();
//
//    // 총 개수 조회
//    long total = jpaQueryFactory.selectFrom(review).where(predicate).fetchCount();
//
//    return new PageImpl<>(reviews, pageable, total);
//  }
//
//  // 사용자가 참여한 매장 조회 (리뷰나 미션 관련)
//  @Override
//  public Page<Store> getMemberStores(Long memberId, Pageable pageable) {
//    BooleanBuilder predicate = new BooleanBuilder();
//    predicate.and(review.member.id.eq(memberId).or(memberMission.member.id.eq(memberId)));  // 사용자 ID로 필터링
//
//    // QueryDSL을 이용해 매장 조회 후 페이징 처리
//    List<Store> stores = jpaQueryFactory
//        .select(store)
//        .from(store)
//        .leftJoin(store.reviewList, review)  // Store와 Review 조인
//        .leftJoin(store.missionList, mission)  // Store와 Mission 조인
//        .where(predicate)
//        .offset(pageable.getOffset())
//        .limit(pageable.getPageSize())
//        .fetch();
//
//    // 총 개수 조회
//    long total = jpaQueryFactory.selectFrom(store).leftJoin(store.reviewList, review).leftJoin(store.missionList, mission).where(predicate).fetchCount();
//
//    return new PageImpl<>(stores, pageable, total);
//  }
//}
