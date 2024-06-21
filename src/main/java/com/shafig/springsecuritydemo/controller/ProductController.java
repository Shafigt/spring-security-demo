package com.shafig.springsecuritydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok("Welcome");
    }

    @GetMapping("{id}")
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Long> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }

}
