package org.example.umc_study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.umc_study.apiPayload.code.BaseErrorCode;
import org.example.umc_study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
