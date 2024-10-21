package com.example.CafeAPP.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {
    private CafeUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseBody , HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\"" + responseBody+ "\"}", httpStatus);
    }
}
