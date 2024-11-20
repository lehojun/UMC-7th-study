//package umc.spring.repository.memberRepository;
//
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import umc.spring.domain.Member;
//import umc.spring.domain.enums.MemberStatus;
//
//public interface MemberRepository extends JpaRepository<Member, Long> {
//  List<Member> findByNameAndStatus(String name, MemberStatus status);
//}