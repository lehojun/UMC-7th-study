package umc.spring.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.RegionRepository.RegionRepository;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService{

    private final RegionRepository regionRepository;

    @Override
    public boolean existCategoryById(Long value) {
        return regionRepository.existsById(value);
    }
}
