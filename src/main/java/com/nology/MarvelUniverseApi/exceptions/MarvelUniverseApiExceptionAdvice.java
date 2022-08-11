package com.nology.MarvelUniverseApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MarvelUniverseApiExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(MarvelUniverseApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String MarvelCharacterNotSeededHandler(MarvelUniverseApiException ex) {
        return ex.getMessage();
    }
}
