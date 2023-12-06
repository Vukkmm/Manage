package com.example.manage.service.impl;

import com.example.manage.entity.Address;
import com.example.manage.exception.NotFoundException;
import com.example.manage.repository.AddressRepository;
import com.example.manage.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    @Transactional
    public Address update(Long id, String apartNumber, String commune, String district, String city, String country) {
        log.info("(update) :id :{}, apartNumber: {}, commune: {}, district : {}, city: {}, country: {}", id, apartNumber, commune, district, city, country);
        Address address = addressRepository.findById(id).orElse(null);
        if (Objects.nonNull(address)) {
            setValueUpdate(address, apartNumber, commune, district, city, country);
            addressRepository.save(address);
        } else {
            throw new NotFoundException("id does not exist");
        }
        return address;
    }


    @Override
    @Transactional
    public void delete(Long id) {
        log.info("(delete) id:{}", id);
        Address address = addressRepository.findById(id).orElse(null);
        if (Objects.nonNull(address)) {
            addressRepository.delete(address);
        } else {
            throw new NotFoundException("id does not exist");
        }
    }

    private void setValueUpdate(Address address, String apartNumber, String commune, String district, String city, String country) {
        address.setApartNumber(apartNumber);
        address.setCommune(commune);
        address.setDistrict(district);
        address.setCity(city);
        address.setCountry(country);
    }
}
