package org.example.umc_study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.umc_study.apiPayload.ApiResponse;
import org.example.umc_study.converter.MemberConverter;
import org.example.umc_study.domain.Member;
import org.example.umc_study.service.MemberService.MemberCommandService;
import org.example.umc_study.web.dto.MemberRequestDTO;
import org.example.umc_study.web.dto.MemberResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
