package com.example.manage.service.impl;

import com.example.manage.dto.request.AddressRequest;
import com.example.manage.dto.response.AddressResponse;
import com.example.manage.entity.Address;
import com.example.manage.repository.AddressRepository;
import com.example.manage.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public Address create(String apartNumber, String commune, String district, String city, String country) {
        log.info("(create) :apartNumber: {}, commune: {}, district : {}, city: {}, country: {}", apartNumber, commune, district, city, country);
        Address address = new Address();
        address.setApartNumber(apartNumber);
        address.setCommune(commune);
        address.setDistrict(district);
        address.setCity(city);
        address.setCountry(country);
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address update(Long id, String apartNumber, String commune, String district, String city, String country) {
        log.info("(create) :id :{}, apartNumber: {}, commune: {}, district : {}, city: {}, country: {}", id, apartNumber, commune, district, city, country);
        Address address = new Address();
        address.setId(id);
        address.setApartNumber(apartNumber);
        address.setCommune(commune);
        address.setDistrict(district);
        address.setCity(city);
        address.setCountry(country);

        return addressRepository.save(address);
    }
}
