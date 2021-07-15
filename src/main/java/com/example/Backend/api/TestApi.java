package com.example.Backend.api;

import com.example.Backend.business.Testbusiness;
import com.example.Backend.exception.BaseException;
import com.example.Backend.model.MregisterRequest;
import com.example.Backend.model.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestApi {

//     HETHOD1 => field Injection
//    @Autowired
//    private Testbusiness business;

    // HEADHOT2 => Constructor Injection
    private final Testbusiness business;

    @Autowired
    public TestApi(Testbusiness business) {
        this.business = business;
    }

    @GetMapping
    // when you want to get json,
    // you are going to return by object
    public TestResponse Test() {
        TestResponse response = new TestResponse();
        response.setFood("Aof");
        response.setFood("KFC");

        return response;
    }

    @GetMapping
    @RequestMapping("/2")
    public TestResponse test2() {
        TestResponse response = new TestResponse();
        response.setFood("Aof");
        response.setFood("KFC");

        return response;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody MregisterRequest request) throws BaseException {
        String response = business.register(request);
        return ResponseEntity.ok(response);

    }
}
