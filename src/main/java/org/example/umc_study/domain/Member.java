package org.example.umc_study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.umc_study.domain.common.BaseEntity;
import org.example.umc_study.domain.enums.Gender;
import org.example.umc_study.domain.enums.MemberStatus;
import org.example.umc_study.domain.enums.SocialType;
import org.example.umc_study.domain.mapping.MemberAgree;
import org.example.umc_study.domain.mapping.MemberMission;
import org.example.umc_study.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(15) DEFAULT 'ACTIVE'")
    private MemberStatus memberStatus;

    private LocalDate inactiveDate;

    @Column(nullable = false)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
}
