package org.animal_api.rest.handlers;

import org.animal_api.utils.exceptions.AnimalNameIsNullException;
import org.animal_api.utils.exceptions.EntityIsNullException;
import org.animal_api.utils.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, Map<String, List<String>>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, List<String>> result = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> {
                    if (result.containsKey(e.getField())) {
                        result.get(e.getField()).add(e.getDefaultMessage());
                    } else {
                        result.put(e.getField(), List.of(e.getDefaultMessage()));
                    }
                });
        return new ResponseEntity<>(getErrorsMap(result), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AnimalNameIsNullException.class})
    public ResponseEntity<Map<String, List<String>>> animalNameIsNullException(AnimalNameIsNullException exception){
        Map<String, List<String>> map = new HashMap<>();
        map.put("errors", Collections.singletonList(exception.getMessage()));

        return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(value = {EntityIsNullException.class})
    public ResponseEntity<Map<String, List<String>>> entityIsNullException(EntityIsNullException exception){
        Map<String, List<String>> map = new HashMap<>();
        map.put("errors", Collections.singletonList(exception.getMessage()));

        return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Map<String, List<String>>> entityNotFoundException(EntityNotFoundException exception){
        Map<String, List<String>> map = new HashMap<>();
        map.put("errors", Collections.singletonList(exception.getMessage()));

        return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    /* Helpers */

    private Map<String, Map<String, List<String>>> getErrorsMap(Map<String, List<String>> errors) {
        Map<String, Map<String, List<String>>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
