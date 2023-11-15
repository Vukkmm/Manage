package com.example.Manage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameRequest {
    private String firstName;
    private String middleName;
    private String lastName;
}
