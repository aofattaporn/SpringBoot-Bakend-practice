package com.example.Backend.api;

import com.example.Backend.business.productBusiness;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductApi {
    private final productBusiness business;

    public ProductApi(productBusiness business) {
        this.business = business;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductID(@PathVariable("id") String id) {
        String respond = business.GetProductId(id);
        return ResponseEntity.ok(respond);
    }

    @GetMapping
    public ResponseEntity<String> testapi() {
        String response = business.GetProductId("123");
        return ResponseEntity.ok(response);
    }

}
