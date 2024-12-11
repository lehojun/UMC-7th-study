package umc.spring.repository.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    // JPA 메서드
    //List<Member> findByNameAndStatus(String name, MemberStatus status);
    Optional<Member> findByEmail(String email);

    // JPQL
//    @Query("select m from Member m where m.name = :name AND m.status = :status")
//    List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);

}
