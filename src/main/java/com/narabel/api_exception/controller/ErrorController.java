package com.narabel.api_exception.controller;

import com.narabel.api_exception.error.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ErrorController {

    @GetMapping("/error1")
    public ResponseEntity<?> notFound() {
        throw new ObjectNotFoundException(UUID.randomUUID().toString());
    }

    @GetMapping("/error2")
    public ResponseEntity<?> obtenerTodos() {
        List<Object> result = new ArrayList<>();
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay objetos registrados");
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
