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
    public FullNameResponse create(FullNameRequest fullNameRequest) {
        FullName fullName = new FullName();
        fullName.setFirstName(fullNameRequest.getFirstName());
        fullName.setMiddleName(fullNameRequest.getMiddleName());
        fullName.setLastName(fullNameRequest.getLastName());
        fullNameRepository.save(fullName);
        FullNameResponse fullNameResponse1 = new FullNameResponse();
        fullNameResponse1.setId(fullName.getId());
        fullNameResponse1.setFirstName(fullName.getFirstName());
        fullNameResponse1.setLastName(fullName.getLastName());
        fullNameResponse1.setMiddleName(fullName.getMiddleName());
        return fullNameResponse1;
    }
}
