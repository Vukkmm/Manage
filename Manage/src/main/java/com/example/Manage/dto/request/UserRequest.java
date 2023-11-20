package com.example.Manage.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRequest {
    private String age;
    private String sex;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String apartNumber;
    private String commune;
    private String district;
    private String city;
    private String country;

}
