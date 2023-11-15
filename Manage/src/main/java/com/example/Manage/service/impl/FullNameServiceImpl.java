package com.example.Manage.service.impl;

import com.example.Manage.dto.request.FullNameRequest;
import com.example.Manage.entity.FullName;
import com.example.Manage.repository.FullNameRepository;
import com.example.Manage.service.FullNameService;
import org.springframework.stereotype.Service;

@Service
public class FullNameServiceImpl implements FullNameService {
    private final FullNameRepository fullNameRepository;

    public FullNameServiceImpl(FullNameRepository fullNameRepository) {
        this.fullNameRepository = fullNameRepository;
    }

    @Override
    public FullName create(FullNameRequest fullNameRequest) {
        FullName fullName = new FullName();
        fullName.setFirstName(fullNameRequest.getFirstName());
        fullName.setMiddleName(fullNameRequest.getMiddleName());
        fullName.setLastName(fullNameRequest.getLastName());
        fullNameRepository.save(fullName);
        return fullName;
    }
}
