package org.example.umc_study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.example.umc_study.apiPayload.code.status.ErrorStatus;
import org.example.umc_study.apiPayload.exception.handler.FoodCategoryHandler;
import org.example.umc_study.converter.MemberConverter;
import org.example.umc_study.converter.MemberPreferConverter;
import org.example.umc_study.domain.FoodCategory;
import org.example.umc_study.domain.Member;
import org.example.umc_study.domain.mapping.MemberPrefer;
import org.example.umc_study.repository.FoodCategoryRepository;
import org.example.umc_study.repository.MemberRepository;
import org.example.umc_study.web.dto.MemberRequestDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
