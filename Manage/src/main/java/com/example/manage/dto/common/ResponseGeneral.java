package com.example.manage.dto.common;

import com.example.manage.utils.DateUtils;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//Phương thức tĩnh thường được sử dụng khi bạn muốn thực hiện một hành động mà không cần thông tin từ một đối tượng cụ thể của lớp.
public class ResponseGeneral<T> {
    private int status;
    private String message;
    private T data;
    private String timestamp;

    public static <T> ResponseGeneral<T> of(int status, String message, T data) {
        // nghĩa là nó sẽ tạo ra 1 cái response
        return of(status, message, data, DateUtils.getCurrentDateString());
        // DateUtils.getCurrentDateString() : trả về một chuỗi biểu diễn của thời gian hiện tại theo định dạng ngày giờ.
    }

    public static <T> ResponseGeneral<T> ofSuccess(String message, T data) {
        return of(HttpStatus.OK.value(), message, data, DateUtils.getCurrentDateString());
    }

    public static <T> ResponseGeneral<T> ofSuccess(String message) {
        return of(HttpStatus.OK.value(), message, null, DateUtils.getCurrentDateString());
    }

    public static <T> ResponseGeneral<T> ofCreated(T data) {
        return of(HttpStatus.CREATED.value(), "create success", data, DateUtils.getCurrentDateString());
    }

    public static <T> ResponseGeneral<T> ofCreated(String message) {
        return of(HttpStatus.CREATED.value(), message, null, DateUtils.getCurrentDateString());
    }

    public static <T> ResponseGeneral<List<T>> ofList(String message, List<T> data) {
        return ResponseGeneral.of(HttpStatus.OK.value(), message, data, DateUtils.getCurrentDateString());
    }

    public static <T> ResponseGeneral<T> ofSuccess( T data) {
        return of(HttpStatus.OK.value(), null, data, DateUtils.getCurrentDateString());
    }


}
