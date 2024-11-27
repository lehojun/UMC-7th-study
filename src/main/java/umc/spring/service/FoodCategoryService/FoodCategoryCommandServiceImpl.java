package umc.spring.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService{
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean existCategoryById(List<Long> values) {
        return values.stream()
                .allMatch(foodCategoryRepository::existsById);
    }
}
