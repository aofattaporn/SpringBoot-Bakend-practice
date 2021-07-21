package com.example.Backend.api;

import com.example.Backend.business.Userbusiness;
import com.example.Backend.exception.BaseException;
import com.example.Backend.model.MloginRequest;
import com.example.Backend.model.MregisterRequest;
import com.example.Backend.model.MregisterResponse;
import com.example.Backend.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserApi {

    // Constructor injection
    private final Userbusiness business;

    public UserApi(Userbusiness business) {
        this.business = business;
    }

    // test get mapping
    @GetMapping
    public TestResponse TestApi() {
        // when you want to get json,
        // you are going to return by object
        TestResponse response = new TestResponse();
        response.setFood("Aof");
        response.setFood("KFC");

        return response;
    }

    // post method for registration system
    @PostMapping("/register")
    public ResponseEntity<MregisterResponse> register(@RequestBody MregisterRequest request) throws BaseException {
        MregisterResponse response = business.register(request);
        return ResponseEntity.ok(response);
    }

    // post mapping for login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MloginRequest request) throws BaseException {
        String response = business.login(request);
        return ResponseEntity.ok(response);
    }



    // test-upload Api
    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);
    }

}
