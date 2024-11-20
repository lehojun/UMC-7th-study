//package umc.spring.repository.memberRepository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import umc.spring.domain.Mission;
//import umc.spring.domain.Review;
//import umc.spring.domain.Store;
//
//public interface MemberRepositoryCustom {
//
//  // 사용자가 참여한 미션과 관련된 정보 조회 (진행 중/완료된 미션)
//  Page<Mission> getMemberMissions(Long memberId, Pageable pageable);
//
//  // 사용자가 작성한 리뷰 조회
//  Page<Review> getMemberReviews(Long memberId, Pageable pageable);
//
//  // 사용자가 참여한 매장 조회 (리뷰나 미션 관련)
//  Page<Store> getMemberStores(Long memberId, Pageable pageable);
//}
