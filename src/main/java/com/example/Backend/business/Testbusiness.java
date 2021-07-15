package com.example.Backend.business;

import com.example.Backend.exception.BaseException;
import com.example.Backend.exception.UserException;
import com.example.Backend.model.MregisterRequest;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class Testbusiness {
    public String register(MregisterRequest request) throws BaseException {
        // valid null request
        if (request == null) {
            throw UserException.requestNull();
        }
        // validate email
        else if (Objects.isNull(request.getEmail())){
            throw  UserException.emailNull();
        }

        // validate...
        return  "Hello world";
    }


}
