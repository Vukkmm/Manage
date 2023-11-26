package com.example.manage.service.impl;

import com.example.manage.dto.request.FullNameRequest;
import com.example.manage.dto.response.FullNameResponse;
import com.example.manage.entity.FullName;
import com.example.manage.repository.FullNameRepository;
import com.example.manage.service.FullNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
    private final FullNameRepository fullNameRepository;

    @Override
    public FullName create(String firstName, String middleName, String lastName) {
        FullName fullName = new FullName();
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);
        return fullNameRepository.save(fullName);
    }
}
