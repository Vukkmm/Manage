package com.example.manage.service.impl;

import com.example.manage.entity.FullName;
import com.example.manage.exception.NotFoundException;
import com.example.manage.repository.FullNameRepository;
import com.example.manage.service.FullNameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    @Transactional
    public FullName update(Long id, String firstName, String middleName, String lastName) {
        log.info("(update) :id: {}, firstName: {}, middleName: {}, lastName: {}", id, firstName, middleName, lastName);
        FullName fullName = fullNameRepository.findById(id).orElse(null);
        if (Objects.nonNull(fullName)) {
            setValueUpdate(fullName, firstName, middleName, lastName);
            fullNameRepository.save(fullName);
        } else {
            throw new NotFoundException("id does not exist");
        }
        return fullName;
    }

    @Override
    @Transactional
    public void detele(Long id) {
        log.info("(delete) id:{}", id);
        FullName fullName = fullNameRepository.findById(id).orElse(null);
        if (Objects.nonNull(fullName)) {
            fullNameRepository.delete(fullName);
        } else {
            throw new NotFoundException("id does not exist");
        }
    }

    private void setValueUpdate(FullName fullName, String firstName, String middleName, String lastName) {
        fullName.setFirstName(firstName);
        fullName.setMiddleName(middleName);
        fullName.setLastName(lastName);
    }

}
