package com.example.Manage.service;

import com.example.Manage.dto.request.FullNameRequest;
import com.example.Manage.entity.FullName;

public interface FullNameService {
    FullName create(FullNameRequest fullNameRequest);
}
