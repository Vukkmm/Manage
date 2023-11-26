package com.example.manage.service.impl;

import com.example.manage.dto.request.AddressRequest;
import com.example.manage.dto.response.AddressResponse;
import com.example.manage.entity.Address;
import com.example.manage.repository.AddressRepository;
import com.example.manage.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address create(String apartNumber, String commune, String district, String city, String country) {

        Address address = new Address();
        address.setApartNumber(apartNumber);
        address.setCommune(commune);
        address.setDistrict(district);
        address.setCity(city);
        address.setCountry(country);
        addressRepository.save(address);
        return address;
    }
}
