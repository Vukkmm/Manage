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
    public AddressResponse create(AddressRequest addressRequest) {
        Address address = new Address();
        address.setApartNumber(addressRequest.getApartNumber());
        address.setCommune(addressRequest.getCommune());
        address.setDistrict(addressRequest.getDistrict());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        addressRepository.save(address);
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressResponse.getId());
        addressResponse.setApartNumber(addressResponse.getApartNumber());
        addressResponse.setCommune(addressResponse.getCommune());
        addressResponse.setDistrict(addressResponse.getDistrict());
        addressResponse.setCity(addressResponse.getCity());
        addressResponse.setCountry(addressResponse.getCountry());
        return addressResponse;
    }
}
