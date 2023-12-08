package com.example.manage.constant;

public class constants {
    public static class StatusException {
        public static final Integer NOT_FOUND = 404;
        public static final Integer CONFLICT = 409;
        public static final Integer BAD_REQUEST = 400;
    }

    public static class Message {
        public static final String DETAIL_SUCCESS = "get detail success";
        public static final String UPDATE_SUCCESS = "update user success";
        public static final String DELETE_SUCCESS = "delete success";
        public static final String USERNAME_EXIST = "Account with the given username or password already exists";
        public static final String ID_EXIST = "id does not exist";

        public static final String LIST_SUCCESS = "Get all list user success";
    }

}
