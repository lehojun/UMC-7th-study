package umc.spring.service.FoodCategoryService;

import umc.spring.domain.FoodCategory;

import java.util.List;

public interface FoodCategoryCommandService {
    public boolean existCategoryById(List<Long> values);
}
