package org.example.umc_study.apiPayload.exception.handler;

import org.example.umc_study.apiPayload.code.BaseErrorCode;
import org.example.umc_study.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
