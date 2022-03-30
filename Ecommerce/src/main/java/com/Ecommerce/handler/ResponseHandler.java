package com.Ecommerce.handler;

import com.Ecommerce.entities.Seller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status,Object resobj1){
        Map<String, Object> map=new HashMap<>();
        map.put("message",message);
        map.put("status",status.value());
        map.put("data",resobj1.toString());
        map.put("date", new Date());
//        System.out.println(resobj1);
//        System.out.println(map);
        return new ResponseEntity<Object>(map,status);

    }
}
