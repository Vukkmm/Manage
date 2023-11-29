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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserFacadeServiceImpl implements UserFacadeService {
    private final AccountService accountService;
    private final AddressService addressService;
    private final FullNameService fullNameService;
    private final UserService userService;


    @Override
    @Transactional
    public UserResponse create(UserRequest request) {
        log.info("(create) request:{}",request );
        Account account = accountService.create(request.getAccountRequest().getUsername(), request.getAccountRequest().getPassword());

        AccountResponse accountResponse = convertToAccountResponse(account);

        FullName fullName = fullNameService.create(
                request.getFullNameRequest().getFirstName(),
                request.getFullNameRequest().getMiddleName(),
                request.getFullNameRequest().getLastName()
        );

        FullNameResponse fullNameResponse = convertToFullNameResponse(fullName);

        Address address = addressService.create(
                request.getAddressRequest().getApartNumber(),
                request.getAddressRequest().getCommune(),
                request.getAddressRequest().getDistrict(),
                request.getAddressRequest().getCity(),
                request.getAddressRequest().getCountry()
        );

        AddressResponse addressResponse = convertToAddressResponse(address);

        User user = userService.create(request.getAge(), request.getSex(), account, fullName, address);

        return new UserResponse(
                accountResponse.getId(),
                user.getAge(),
                user.getSex(),
                accountResponse,
                fullNameResponse,
                addressResponse
        );
    }

    private AddressResponse convertToAddressResponse(Address address) {
        return new AddressResponse(
                address.getId(),
                address.getApartNumber(),
                address.getCommune(),
                address.getDistrict(),
                address.getCity(),
                address.getCountry()
        );
    }
    private AccountResponse convertToAccountResponse(Account account) {
        return  new AccountResponse(
                account.getId(),
                account.getUsername(),
                account.getPassword()
        );
    }

    private FullNameResponse convertToFullNameResponse(FullName fullName) {
        return new FullNameResponse(
                fullName.getId(),
                fullName.getFirstName(),
                fullName.getMiddleName(),
                fullName.getLastName()
        );
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        UserResponse userResponse = userService.detail(id);

        Account account = accountService.update(userResponse.getAccountResponse().getId(), request.getAccountRequest().getUsername(), request.getAccountRequest().getPassword());

        AccountResponse accountResponse = convertToAccountResponse(account);

        FullName fullName = fullNameService.update(
                userResponse.getFullNameResponse().getId(),
                request.getFullNameRequest().getFirstName(),
                request.getFullNameRequest().getMiddleName(),
                request.getFullNameRequest().getLastName()
        );

        FullNameResponse fullNameResponse = convertToFullNameResponse(fullName);

        Address address = addressService.update(
                userResponse.getAddressResponse().getId(),
                request.getAddressRequest().getApartNumber(),
                request.getAddressRequest().getCommune(),
                request.getAddressRequest().getDistrict(),
                request.getAddressRequest().getCity(),
                request.getAddressRequest().getCountry()
        );

        AddressResponse addressResponse = convertToAddressResponse(address);

        User user = userService.update(userResponse.getId(), request.getAge(), request.getSex(), account, fullName, address);

        return new UserResponse(
                userResponse.getId(),
                user.getAge(),
                user.getSex(),
                accountResponse,
                fullNameResponse,
                addressResponse
        );

    }




}
