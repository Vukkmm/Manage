package com.example.Manage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private Integer age;
    private String sex;
    private Long fullNameId;
    private Long addressId;
}
