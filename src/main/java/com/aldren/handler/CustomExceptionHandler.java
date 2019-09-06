package com.aldren.handler;

import com.aldren.exception.RecordNotFoundException;
import com.aldren.model.Response;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({RecordNotFoundException.class})
    public @ResponseBody Response handleNotFoundException(Exception e, WebRequest w) {
        return Response.builder()
                .timestamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .status(HttpStatus.NOT_FOUND.value())
                .description(HttpStatus.NOT_FOUND.name())
                .message(e.getLocalizedMessage())
                .path(w.getContextPath())
                .build();
    }

}
