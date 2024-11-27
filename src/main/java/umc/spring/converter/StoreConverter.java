package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.MemberDTO.MemberResponseDTO;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.AddDto request) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store) {
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .regionId(store.getRegion().getId())
                .build();
    }
}
