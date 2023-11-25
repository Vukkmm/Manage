package com.example.Manage.service;

import com.example.Manage.dto.request.AddressRequest;
import com.example.Manage.dto.response.AddressResponse;
import com.example.Manage.entity.Address;

public interface AddressService {
    AddressResponse create(AddressRequest addressRequest);
}
