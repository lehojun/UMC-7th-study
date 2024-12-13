package org.example.umc_study.service.MemberService;

import org.example.umc_study.domain.Member;
import org.example.umc_study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
