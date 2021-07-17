package com.example.Backend.api;

import com.example.Backend.business.Testbusiness;
import com.example.Backend.exception.BaseException;
import com.example.Backend.model.MregisterRequest;
import com.example.Backend.model.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class TestApi {

    // HEADHOT2 => Constructor Injection
    private final Testbusiness business;

    @Autowired
    public TestApi(Testbusiness business) {
        this.business = business;
    }

    // when you want to get json,
    // you are going to return by object
    @GetMapping
    public TestResponse Test() {
        TestResponse response = new TestResponse();
        response.setFood("Aof");
        response.setFood("KFC");

        return response;
    }

    // get mapping from adding url
    @GetMapping
    @RequestMapping("/2")
    public TestResponse test2() {
        TestResponse response = new TestResponse();
        response.setFood("Aof");
        response.setFood("KFC");

        return response;
    }

    // post method for registration system
    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody MregisterRequest request) throws BaseException {
        String response = business.register(request);
        return ResponseEntity.ok(response);

    }

//     test-upload Api
    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);
    }
}
