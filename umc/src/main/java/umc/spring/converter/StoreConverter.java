package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.AddStoreDTO request) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
