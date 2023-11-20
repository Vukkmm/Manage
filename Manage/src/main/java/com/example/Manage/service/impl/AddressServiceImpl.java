package com.example.Manage.service.impl;

import com.example.Manage.dto.request.AddressRequest;
import com.example.Manage.dto.response.AddressResponse;
import com.example.Manage.entity.Address;
import com.example.Manage.repository.AddressRepository;
import com.example.Manage.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public AddressResponse create(String apartNumber, String commune, String district, String city, String country) {
        Address address = new Address();
        address.setApartNumber(apartNumber);
        address.setCommune(commune);
        address.setDistrict(district);
        address.setCity(city);
        address.setCountry(country);
        addressRepository.save(address);
        return AddressResponse.of(address.getId(), apartNumber, commune, district, city, country);
    }
}
