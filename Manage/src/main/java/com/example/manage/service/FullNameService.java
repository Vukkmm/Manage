package com.example.manage.service;

import com.example.manage.entity.FullName;

public interface FullNameService {
    FullName create(String firstName, String middleName, String lastName);

    FullName update(Long id, String firstName, String middleName, String lastName);

     void detele(Long id);
}
