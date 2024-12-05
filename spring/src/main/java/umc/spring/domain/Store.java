package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(length = 100)
  private String address;

  private Float score;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id")
  private Region region;

  @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
  private List<Review> reviewList;

  public void setRegion(Region region) {
    this.region = region;
  }

  @Override
  public String toString() {
    return "Store{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", score=" + score +
        ", region=" + (region != null ? region.getName() : "N/A") +
        '}';
  }
}