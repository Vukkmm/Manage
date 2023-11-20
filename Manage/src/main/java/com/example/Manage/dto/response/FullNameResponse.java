package com.example.Manage.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FullNameResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
}
