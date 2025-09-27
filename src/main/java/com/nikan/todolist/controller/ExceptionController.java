package com.nikan.todolist.controller;

import com.nikan.todolist.dto.ExceptionDto;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDto>> handlerError(MethodArgumentNotValidException e) {
        List<ExceptionDto> exceptionDtos = e.getBindingResult()
                .getFieldErrors().stream()
                .map(error -> new ExceptionDto(error.getField(), messageSourceAccessor.getMessage(error.getDefaultMessage())))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(exceptionDtos);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<List<ExceptionDto>> handlerError(RuntimeException e) {
        ExceptionDto exceptionDto = new ExceptionDto("error", messageSourceAccessor.getMessage(e.getMessage()));
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Arrays.asList(exceptionDto));
    }
}
