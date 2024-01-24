package com.footstep.domain.base.advice;

import com.footstep.domain.base.entity.CommonResult;
import com.footstep.domain.base.exception.NotFoundException;
import com.footstep.domain.base.exception.UnauthorizedException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class CommonControllerAdvice {

    @ExceptionHandler({
            MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<CommonResult> handleBadRequest(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(new CommonResult(false, BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler({
    })
    public ResponseEntity<CommonResult> handleBadRequest(final Exception e) {
        log.debug("HandleBadRequest : {}", e.getMessage());
        return ResponseEntity.badRequest().body(new CommonResult(false, BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler({UnauthorizedException.class, JwtException.class})
    public ResponseEntity<CommonResult> handleUnauthorized(final Exception e) {
        log.debug("UnauthorizedException : {}", e.getMessage());
        log.debug("Exception Stack Trace : \n{}", e.getStackTrace());
        return new ResponseEntity<>(new CommonResult(false, UNAUTHORIZED.value(), e.getMessage()), UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CommonResult> handleNotFound(final Exception e) {
        log.debug("NotFoundException : {}", e.getMessage());
        return ResponseEntity.status(NOT_FOUND).body(new CommonResult(false, NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CommonResult> handleInternalServerError(RuntimeException e) {
        log.debug("RuntimeException : {}", e.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new CommonResult(false, INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
}
