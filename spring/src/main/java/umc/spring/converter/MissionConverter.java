package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.StoreRequestDTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class MissionConverter {

  public static Mission toMission(StoreRequestDTO.AddMissionDTO request, Store store) {

    return Mission.builder()
        .reward(request.getReward())
        .deadline(request.getDeadline())
        .missionSpec(request.getMissionSpec())
        .store(store)
        .build();
  }
}