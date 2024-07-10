package com.dubaicustoms.umsservice.exception;


import com.dubaicustoms.umsservice.domain.genericresponse.ResultStatus;
import com.dubaicustoms.umsservice.domain.genericresponse.ResultStatusResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionControllerAdvice {

    public ExceptionControllerAdvice() {
        super();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ResultStatus status = new ResultStatus();
        status.setStatus("FAILED");
        status.setErrorCode("Technical Difficulty!");
        status.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(new ResultStatusResponse(status), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UmsException.class)
    public ResponseEntity<Object> handleUmsException(UmsException ex) {
        ResultStatus status = new ResultStatus();
        status.setStatus("FAILED");
        status.setErrorCode(Integer.toString(ex.getHttpStatus().value()));
        status.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(new ResultStatusResponse(status), ex.getHttpStatus());
    }

}
