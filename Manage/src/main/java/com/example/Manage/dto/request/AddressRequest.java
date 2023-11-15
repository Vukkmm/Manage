package com.example.Manage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Integer ApartNumber;
    private String commune;
    private String district;
    private String city;
    private String country;
}
