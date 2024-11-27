package umc.spring.web.dto.StoreDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class AddDto {

        @NotBlank
        String name;

        @NotNull
        @ExistRegion
        Long regionId;

        String address;


    }
}
