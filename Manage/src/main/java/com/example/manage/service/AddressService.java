package com.example.manage.service;

import com.example.manage.dto.request.AddressRequest;
import com.example.manage.dto.response.AddressResponse;
import com.example.manage.entity.Address;

public interface AddressService {
    Address create(String apartNumber, String commune, String district, String city, String country);
}
