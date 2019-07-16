package com.kou.common.spring.advice;

import com.kou.common.util.Responses;
import com.kou.common.util.exception.BusinessException;
import com.kou.common.util.exception.DaoException;
import com.kou.common.util.exception.RemoteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class CommonExceptionAdviceCtrl {

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity handleOtherExceptions(final HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        return new ResponseEntity<>(Responses.error(ex.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity handleOtherExceptions(final BusinessException ex, HttpServletRequest request) {
        log.error("请求 "+request.getRequestURI()+" 出错", ex);
        return new ResponseEntity<>(ex.getResponses(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {RemoteException.class})
    public ResponseEntity handleOtherExceptions(final RemoteException ex, HttpServletRequest request) {
        log.error("服务间请求 "+request.getRequestURI()+"失败", ex);
        return new ResponseEntity<>(ex.getResponses(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public ResponseEntity handleOtherExceptions(final Exception ex, HttpServletRequest request) {
        BindingResult bindingResult = null;
        if (BindException.class.isInstance(ex)){
            bindingResult = ((BindException)ex).getBindingResult();
        }else if (MethodArgumentNotValidException.class.isInstance(ex)){
            bindingResult = ((MethodArgumentNotValidException)ex).getBindingResult();
        }
        if (bindingResult != null && bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            return new ResponseEntity<>(Responses.error(fieldError.getField() + ":" + fieldError.getDefaultMessage()), HttpStatus.PRECONDITION_FAILED);
        }
        return new ResponseEntity<>(Responses.error(ex.getMessage()), HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    public ResponseEntity handleOtherExceptions(final HttpMediaTypeNotSupportedException ex, HttpServletRequest request) {
        return new ResponseEntity<>(Responses.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DaoException.class})
    public ResponseEntity handleOtherExceptions(final DaoException ex, HttpServletRequest request) {
        log.error("请求 "+request.getRequestURI()+" 出错", ex);
        return new ResponseEntity<>(Responses.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity handleOtherExceptions(final HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.error("请求 "+request.getRequestURI()+" 参数解析异常", ex);
        return new ResponseEntity<>(Responses.error("请求参数格式有误"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity handleOtherExceptions(final Throwable ex, HttpServletRequest request) {
        log.error("请求 "+request.getRequestURI()+" 出错", ex);
        return new ResponseEntity<>(Responses.error("系统繁忙，请稍后再试"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}