package umc.spring.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import umc.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
