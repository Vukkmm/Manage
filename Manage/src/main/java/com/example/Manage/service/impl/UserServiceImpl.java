package com.example.Manage.service.impl;

import com.example.Manage.dto.request.UserRequest;
import com.example.Manage.dto.response.UserResponse;
import com.example.Manage.entity.User;
import com.example.Manage.repository.AccountRepository;
import com.example.Manage.repository.UserRepository;
import com.example.Manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
//Annotation này được sử dụng động sinh ra một constructor chứa tất cả các trường của lớp được đánh dấu là final or @NonNull.

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setSex(userRequest.getSex());
        userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setSex(user.getSex());
        userResponse.setAge(user.getAge());
        return userResponse;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
