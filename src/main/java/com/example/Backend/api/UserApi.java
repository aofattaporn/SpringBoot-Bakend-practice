package com.example.Backend.api;

import com.example.Backend.business.Userbusiness;
import com.example.Backend.entity.User;
import com.example.Backend.exception.BaseException;
import com.example.Backend.model.MregisterRequest;
import com.example.Backend.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserApi {

    // HEADHOT2 => Constructor Injection
    private final Userbusiness business;
    public UserApi(Userbusiness business) {
        this.business = business;
    }

    // when you want to get json,
    // you are going to return by object
    @GetMapping
    public TestResponse TestApi() {
        TestResponse response = new TestResponse();
        response.setFood("Aof");
        response.setFood("KFC");

        return response;
    }

    // post method for registration system
    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestBody MregisterRequest request) throws BaseException {
        User response = business.register(request);
        return ResponseEntity.ok(response);
    }

    //      test-upload Api
    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);
    }

}
