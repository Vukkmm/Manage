package com.example.Manage.facade.impl;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.dto.response.AccountResponse;
import com.example.Manage.dto.response.AddressResponse;
import com.example.Manage.dto.response.FullNameResponse;
import com.example.Manage.dto.response.UserResponse;
import com.example.Manage.facade.UserFacadeService;
import com.example.Manage.service.AccountService;
import com.example.Manage.service.AddressService;
import com.example.Manage.service.FullNameService;
import com.example.Manage.service.UserService;
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
    public UserResponse create(UserRequest userRequest) {

        AccountResponse accountResponse = accountService.create(userRequest.getAccountRequest());

        FullNameResponse fullNameResponse = fullNameService.create(userRequest.getFullNameRequest());

        AddressResponse addressResponse = addressService.create(userRequest.getAddressRequest());

        UserResponse userResponse = userService.create(userRequest);
        userResponse.setAccountResponse(accountResponse);
        userResponse.setAddressResponse(addressResponse);
        userResponse.setFullNameResponse(fullNameResponse);

        return userResponse;
    }
}
