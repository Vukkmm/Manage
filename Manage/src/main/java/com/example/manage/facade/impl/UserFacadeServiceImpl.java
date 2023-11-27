package com.example.manage.facade.impl;

import com.example.manage.dto.request.UserRequest;
import com.example.manage.dto.response.AccountResponse;
import com.example.manage.dto.response.AddressResponse;
import com.example.manage.dto.response.FullNameResponse;
import com.example.manage.dto.response.UserResponse;
import com.example.manage.entity.Account;
import com.example.manage.entity.Address;
import com.example.manage.entity.FullName;
import com.example.manage.entity.User;
import com.example.manage.facade.UserFacadeService;
import com.example.manage.service.AccountService;
import com.example.manage.service.AddressService;
import com.example.manage.service.FullNameService;
import com.example.manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserFacadeServiceImpl implements UserFacadeService {
    private final AccountService accountService;
    private final AddressService addressService;
    private final FullNameService fullNameService;
    private final UserService userService;


    @Override
    public UserResponse create(UserRequest request) {
        Account account = accountService.create(request.getAccountRequest().getUsername(), request.getAccountRequest().getPassword());

        AccountResponse accountResponse = new AccountResponse(
                account.getId(),
                account.getUsername(),
                account.getPassword()
        );

        FullName fullName = fullNameService.create(
                request.getFullNameRequest().getFirstName(),
                request.getFullNameRequest().getMiddleName(),
                request.getFullNameRequest().getLastName()
        );

        FullNameResponse fullNameResponse = new FullNameResponse(
                fullName.getId(),
                fullName.getFirstName(),
                fullName.getMiddleName(),
                fullName.getLastName()
        );

        Address address = addressService.create(
                request.getAddressRequest().getApartNumber(),
                request.getAddressRequest().getCommune(),
                request.getAddressRequest().getDistrict(),
                request.getAddressRequest().getCity(),
                request.getAddressRequest().getCountry()
        );

        AddressResponse addressResponse = new AddressResponse(
                address.getId(),
                address.getApartNumber(),
                address.getCommune(),
                address.getDistrict(),
                address.getCity(),
                address.getCountry()

        );

        User user = userService.create(request.getAge(), request.getSex(), account, fullName, address);

        UserResponse response = new UserResponse(
                accountResponse.getId(),
                user.getAge(),
                user.getSex(),
                accountResponse,
                fullNameResponse,
                addressResponse
        );

        return response;
    }

}
