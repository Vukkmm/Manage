package com.example.manage.service;

import com.example.manage.entity.Address;

public interface AddressService {
    Address create(String apartNumber, String commune, String district, String city, String country);

    Address update(Long id, String apartNumber, String commune, String district, String city, String country);

    void delete(Long id);
}
