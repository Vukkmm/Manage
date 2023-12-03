package com.example.manage.controller;

import com.example.manage.dto.common.ResponseGeneral;
import com.example.manage.dto.request.UserRequest;
import com.example.manage.dto.response.UserResponse;
import com.example.manage.facade.UserFacadeService;
import com.example.manage.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.manage.constant.constants.Message.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserFacadeService userFacadeService;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseGeneral<UserResponse> create(@RequestBody UserRequest request) {
        log.info("(create) request:{}",request );
        return ResponseGeneral.ofCreated(userFacadeService.create(request));
    }

    @GetMapping("{id}")
    public  ResponseGeneral<UserResponse> detail(@PathVariable Long id) {
        log.info("(detail) id:{}",id );
        return ResponseGeneral.ofSuccess(DETAIL_SUCCESS ,userService.detail(id));
    }

    @PutMapping("{id}")
    public  ResponseGeneral<UserResponse> update(@PathVariable Long id, @RequestBody UserRequest request) {
        log.info("(update) id:{}, request: {}", id, request );
        return ResponseGeneral.ofSuccess(UPDATE_SUCCESS ,userFacadeService.update(id, request));
    }

    @DeleteMapping("{id}")
    public  ResponseGeneral<Void> delete(@PathVariable Long id) {
        log.info("(delete) id:{}",id);
        userFacadeService.delete(id);
        return ResponseGeneral.ofSuccess(DELETE_SUCCESS);
    }

}
