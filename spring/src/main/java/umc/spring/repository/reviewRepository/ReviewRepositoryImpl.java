//package umc.spring.repository.reviewRepository;
//
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import umc.spring.domain.QReview;
//import umc.spring.domain.Review;
//import umc.spring.domain.Store;
//import umc.spring.domain.Member;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
//
//  private final JPAQueryFactory jpaQueryFactory;
//  private final QReview review = QReview.review;
//
//  @Override
//  public Page<Review> dynamicQueryWithBooleanBuilder(Long memberId, Long storeId, Pageable pageable) {
//    BooleanBuilder predicate = new BooleanBuilder();
//
//    // 필터링 조건 설정: 멤버 ID와 가게 ID
//    if (memberId != null) {
//      predicate.and(review.member.id.eq(memberId));
//    }
//
//    if (storeId != null) {
//      predicate.and(review.store.id.eq(storeId));
//    }
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
//}
