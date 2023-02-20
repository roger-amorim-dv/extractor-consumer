package com.extractorconsumer.controller;

import com.extractorconsumer.dto.ApplicationDTO;
import com.extractorconsumer.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/application")
public class ApplicationController {

    @Autowired
    private final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApplicationDTO> createCustomer(final @RequestBody ApplicationDTO applicationDTO) {
        try {
            return new ResponseEntity<>(applicationService.createApplication(applicationDTO), HttpStatus.CREATED);
        } catch (final Throwable ex) {
            return new ResponseEntity<>(ApplicationDTO.builder().build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ApplicationDTO>> getApplications() {
        try {
            return new ResponseEntity<>(applicationService.getApplicationDTOList(), HttpStatus.OK);
        } catch (final Throwable ex) {
            return new ResponseEntity<>(List.of(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
