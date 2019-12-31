package com.reto.slc.exception;

import com.reto.slc.model.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({IOException.class, SessionNotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(exception, request.getRequestURI());
        LogManager.getLogger(this.getClass()).info(" ERROR: NOT_FOUND, "+ errorMessage);
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorized(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(exception, "");
        LogManager.getLogger(this.getClass()).info(" ERROR: UNAUTHORIZED, "+ errorMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class, MalformedHeaderException.class})
    @ResponseBody
    public ErrorMessage badRequest(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(exception, "");
        LogManager.getLogger(this.getClass()).info(" ERROR: BAD_REQUEST, "+ errorMessage);
        return errorMessage;
    }


}
