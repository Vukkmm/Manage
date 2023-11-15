package com.example.Manage.controller;

import com.example.Manage.dto.request.AddressRequest;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.Address;
import com.example.Manage.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody AddressRequest addressRequest) {
        Address address1 = addressService.create(addressRequest);
        return ResponseEntity.ok().body(address1);
    }
}
