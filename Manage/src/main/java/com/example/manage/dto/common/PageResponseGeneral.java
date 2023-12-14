package com.example.manage.dto.common;

import com.example.manage.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PageResponseGeneral<T> {
    private int status;
    private String message;
    private T data;
    private String timestamp;

    public static <T> PageResponseGeneral<T> ofSuccess( T data) {
        return of(HttpStatus.OK.value(),null, data, DateUtils.getCurrentDateString());
    }
}
