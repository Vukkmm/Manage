package com.example.Manage.service;

import com.example.Manage.dto.request.AddressRequest;
import com.example.Manage.entity.Address;

public interface AddressService {
    Address create(AddressRequest addressRequest);
}
