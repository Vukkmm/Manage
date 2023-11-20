package com.example.Manage.facade.impl;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.dto.response.AccountResponse;
import com.example.Manage.dto.response.AddressResponse;
import com.example.Manage.dto.response.FullNameResponse;
import com.example.Manage.dto.response.UserResponse;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.Address;
import com.example.Manage.entity.FullName;
import com.example.Manage.entity.User;
import com.example.Manage.facade.UserFacadeService;
import com.example.Manage.service.AccountService;
import com.example.Manage.service.AddressService;
import com.example.Manage.service.FullNameService;
import com.example.Manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.Manage.untils.MapperUtils.MODEL_MAPPER;

@Service
@RequiredArgsConstructor
public class UserFacadeServiceImpl implements UserFacadeService {
    private final AccountService accountService;
    private final AddressService addressService;
    private final FullNameService fullNameService;
    private final UserService userService;
    @Override
    public UserResponse create(UserRequest userRequest) {

        User user = userService.create(userRequest.getSex(), userRequest.getAge());

        AccountResponse accountResponse = accountService.create(userRequest.getUsername(), userRequest.getPassword());

        FullNameResponse fullNameResponse = fullNameService.create(userRequest.getFirstName(), userRequest.getMiddleName(), userRequest.getLastName());

        AddressResponse addressResponse = addressService.create(userRequest.getApartNumber(), userRequest.getCommune(), userRequest.getDistrict(), userRequest.getCity(), userRequest.getCountry());

        user.setAccount(MODEL_MAPPER.map(accountResponse, Account.class));
        user.setFullName(MODEL_MAPPER.map(fullNameResponse, FullName.class));
        user.setAddress(MODEL_MAPPER.map(addressResponse, Address.class));
        userService.save(user);

        return UserResponse.of(user.getId(), user.getAge(), user.getSex(), accountResponse, fullNameResponse, addressResponse);
    }
}
