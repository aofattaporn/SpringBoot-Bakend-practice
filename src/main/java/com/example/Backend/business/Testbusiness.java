package com.example.Backend.business;

import com.example.Backend.model.MregisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class Testbusiness {
    public String register(MregisterRequest request) throws IOException {
        if (request == null) {
            throw new IOException("null.request");
        }
        // validate email
        else if (Objects.isNull(request.getEmail())){
            throw  new IOException("null.email");
        }
        else if (Objects.isNull(request.getPassword())){
            throw  new IOException("null.password eiei");
        }
        // validate...
        return  "Hello world";
    }


}
