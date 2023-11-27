package com.example.manage.utils;

import java.time.LocalDate;

public class DateUtils {
    public static String getCurrentDateString() {
        return LocalDate.now().toString();
    }
}
