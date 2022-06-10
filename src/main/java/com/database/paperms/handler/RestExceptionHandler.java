package com.database.paperms.handler;

import com.database.paperms.response.ResultData;
import com.database.paperms.response.ReturnCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: com.database.paperms.handler.RestExceptionHandler
 * Created by zjj
 * Date: 2022-05-06 15:06
 */


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        return ResultData.fail(ReturnCode.RC500.getCode(), e.getMessage());
    }

}
