package com.example.apidoublepartnerds.utils;

import com.example.apidoublepartnerds.aplication.entities.BaseResponseDto;
import com.example.apidoublepartnerds.aplication.entities.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class APIResponse {

    public static <T> ResponseEntity<BaseResponseDto<T>> buildHttpResponse(BaseResponseDto<T> responseEvent) {
        final HttpStatus httpStatus = parseResponseCode(responseEvent.getCode());
        return new ResponseEntity<>(responseEvent, httpStatus);
    }

    public static HttpStatus parseResponseCode(final ResponseCode code) {
        log.debug("method: parseResponseCode({})", code);
        switch (code) {
            case OK:
                return HttpStatus.OK;

            case NO_CONTENT:
                return HttpStatus.NO_CONTENT;

            case BAD_REQUEST:
                return HttpStatus.BAD_REQUEST;

            case CONFLICT:
                return HttpStatus.CONFLICT;

            case ERROR:
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
