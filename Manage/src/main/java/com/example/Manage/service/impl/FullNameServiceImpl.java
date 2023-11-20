package com.example.Manage.service.impl;

import com.example.Manage.dto.request.FullNameRequest;
import com.example.Manage.dto.response.FullNameResponse;
import com.example.Manage.entity.FullName;
import com.example.Manage.repository.FullNameRepository;
import com.example.Manage.service.FullNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
    private final FullNameRepository fullNameRepository;

    @Override
    public FullNameResponse create(String firstName, String middleName, String lastName) {
        FullName fullName = new FullName();
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);
        fullNameRepository.save(fullName);
        return FullNameResponse.of(fullName.getId(), firstName,middleName,lastName);
    }
}
