package umc.spring.repository.memberRepository;

import com.querydsl.core.Tuple;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

public interface MemberRepositoryCustom {

    public Member findMemberById(Long memberId);
}
