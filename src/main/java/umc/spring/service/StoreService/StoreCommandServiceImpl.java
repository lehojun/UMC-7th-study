package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository.RegionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddDto request) {
        Store store = StoreConverter.toStore(request);
        Long regionId = request.getRegionId();

        if(regionId != null) {
            Region foundRegion = regionRepository.findById(regionId)
                    .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
            store.setRegion(foundRegion);
        }
        return storeRepository.save(store);
    }


}
