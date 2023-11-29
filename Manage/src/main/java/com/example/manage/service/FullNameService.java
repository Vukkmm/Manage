package com.example.manage.service;

import com.example.manage.dto.request.FullNameRequest;
import com.example.manage.dto.response.FullNameResponse;
import com.example.manage.entity.FullName;

public interface FullNameService {
    FullName create(String firstName, String middleName, String lastName);

    FullName update(Long id, String firstName, String middleName, String lastName);
}
