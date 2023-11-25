package com.example.Manage.service;

import com.example.Manage.dto.request.FullNameRequest;
import com.example.Manage.dto.response.FullNameResponse;
import com.example.Manage.entity.FullName;

public interface FullNameService {

    FullNameResponse create(FullNameRequest fullNameRequest);
}
