package com.example.Manage.controller;

import com.example.Manage.dto.request.FullNameRequest;
import com.example.Manage.entity.Address;
import com.example.Manage.entity.FullName;
import com.example.Manage.service.FullNameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fullName")
public class FullNameController {
    private final FullNameService fullNameService;

    public FullNameController(FullNameService fullNameService) {
        this.fullNameService = fullNameService;
    }

    @PostMapping
    public ResponseEntity<FullName> create(@RequestBody FullNameRequest fullNameRequest) {
        FullName fullName = fullNameService.create(fullNameRequest);
        return ResponseEntity.ok().body(fullName);
    }
}
