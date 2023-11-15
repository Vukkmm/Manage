package com.example.Manage.service.impl;

import com.example.Manage.dto.request.AddressRequest;
import com.example.Manage.entity.Address;
import com.example.Manage.repository.AddressRepository;
import com.example.Manage.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(AddressRequest addressRequest) {
        Address address = new Address();
        address.setApartNumber(addressRequest.getApartNumber());
        address.setCommune(addressRequest.getCommune());
        address.setDistrict(addressRequest.getDistrict());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        addressRepository.save(address);
        return address;
    }
}
