package com.gradle.mustache.commons.inif;

import com.gradle.mustache.commons.dto.ResponseCode;
import com.gradle.mustache.commons.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IResponseController {
    default ResponseEntity<ResponseDto> makeResponseEntity(HttpStatus httpStatus
            , ResponseCode responseCode
            , String message
            , Object responseData) {
        ResponseDto dto = ResponseDto.builder()
                .responseCode(responseCode)
                .message(message)
                .responseData(responseData)
                .build();
        return ResponseEntity.status(httpStatus).body(dto);
    }
}
