package com.example.manage.service.impl;

import com.example.manage.dto.request.FullNameRequest;
import com.example.manage.dto.response.FullNameResponse;
import com.example.manage.entity.FullName;
import com.example.manage.repository.FullNameRepository;
import com.example.manage.service.FullNameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FullNameServiceImpl implements FullNameService {
    private final FullNameRepository fullNameRepository;

    @Override
    @Transactional
    public FullName create(String firstName, String middleName, String lastName) {
        log.info("(create) :firstName: {}, middleName: {}, lastName: {}", firstName, middleName, lastName);
        FullName fullName = new FullName();
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);
        return fullNameRepository.save(fullName);
    }

    @Override
    public FullName update(Long id, String firstName, String middleName, String lastName) {
        log.info("(create) :id: {}, firstName: {}, middleName: {}, lastName: {}", id, firstName, middleName, lastName);
        FullName fullName = new FullName();
        fullName.setId(id);
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);

        return fullNameRepository.save(fullName);
    }
}
