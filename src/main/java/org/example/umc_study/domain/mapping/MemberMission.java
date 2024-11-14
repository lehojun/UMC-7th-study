package org.example.umc_study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.example.umc_study.domain.Member;
import org.example.umc_study.domain.Mission;
import org.example.umc_study.domain.common.BaseEntity;
import org.example.umc_study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

}
