package umc.spring.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {

  public static Store toStore(StoreRequestDTO.AddStoreDTO request) {

    return Store.builder()
        .name(request.getName())
        .address(request.getAddress())
        .build();
  }

  public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
    return StoreResponseDTO.ReviewPreViewDTO.builder()
        .ownerNickname(review.getMember().getName())
        .score(review.getScore())
        .createdAt(review.getCreatedAt().toLocalDate())
        .body(review.getBody())
        .build();
  }
  public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

    List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
        .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

    return StoreResponseDTO.ReviewPreViewListDTO.builder()
        .isLast(reviewList.isLast())
        .isFirst(reviewList.isFirst())
        .totalPage(reviewList.getTotalPages())
        .totalElements(reviewList.getTotalElements())
        .listSize(reviewPreViewDTOList.size())
        .reviewList(reviewPreViewDTOList)
        .build();
  }
}