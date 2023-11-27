package com.example.manage.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserResponse {
    private Long id;
    private String age;
    private String sex;
    private AccountResponse accountResponse;
    private FullNameResponse fullNameResponse;
    private AddressResponse addressResponse;
}
