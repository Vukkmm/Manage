package com.example.Manage.service.impl;

import com.example.Manage.entity.User;
import com.example.Manage.repository.AccountRepository;
import com.example.Manage.repository.AddressRepository;
import com.example.Manage.repository.FullNameRepository;
import com.example.Manage.repository.UserRepository;
import com.example.Manage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
//Annotation này được sử dụng động sinh ra một constructor chứa tất cả các trường của lớp được đánh dấu là final or @NonNull.

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(String age, String sex) {
        User user = new User();
        user.setSex(sex);
        user.setAge(age);
        return userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
