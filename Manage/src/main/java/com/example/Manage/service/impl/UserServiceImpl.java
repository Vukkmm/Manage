package com.example.Manage.service.impl;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.entity.Account;
import com.example.Manage.entity.Address;
import com.example.Manage.entity.FullName;
import com.example.Manage.entity.User;
import com.example.Manage.repository.AccountRepository;
import com.example.Manage.repository.AddressRepository;
import com.example.Manage.repository.FullNameRepository;
import com.example.Manage.repository.UserRepository;
import com.example.Manage.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final FullNameRepository fullNameRepository;
    private final AddressRepository addressRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository, FullNameRepository fullNameRepository, AddressRepository addressRepositoryl) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.fullNameRepository = fullNameRepository;
        this.addressRepository = addressRepositoryl;
    }

    @Override
    public User create(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        Account account = new Account();
        account.setId(userRequest.getId());
        accountRepository.save(account);

        user.setSex(userRequest.getSex());
        user.setAge(userRequest.getAge());

        FullName fullName = new FullName();
        fullName.setId(userRequest.getFullNameId());
        fullNameRepository.save(fullName);
        user.setFullName(fullName);

        Address address = new Address();
        address.setId(userRequest.getAddressId());
        addressRepository.save(address);
        user.setAddress(address);

        userRepository.save(user);
        return user;
    }
}
