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

    public  UserResponse(Long id, String age, String sex,
                         Long accountId, String username, String password,
                         Long fullNameId, String firstName, String middleName, String lastName,
                         Long addressId, String apartNumber, String commune, String district, String city, String country
    ) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        accountResponse = new AccountResponse(accountId, username, password);
        fullNameResponse = new FullNameResponse( fullNameId, firstName, middleName, lastName);
        addressResponse = new AddressResponse(accountId, apartNumber, commune, district, city, country);
    }

}
