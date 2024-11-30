package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    @PostMapping("/add")
    public ApiResponse<MissionResponseDTO.AddResultDTO> Add(@RequestBody @Valid MissionRequestDTO.AddDTO request) {

        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

    @PostMapping("/join")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> Join(@RequestBody @Valid MemberMissionRequestDTO.JoinDTO request) {
        MemberMission memberMission = memberMissionCommandService.joinMission(request);

        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}

