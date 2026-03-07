package com.bank.bank_backend.controller;

import com.bank.bank_backend.model.User;
import com.bank.bank_backend.model.Transaction;
import com.bank.bank_backend.model.PinRequest;
import com.bank.bank_backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    // =============================
    // SIGNUP
    // =============================
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // =============================
    // LOGIN
    // =============================
    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> loginData) {

        String email = loginData.get("email");
        String password = loginData.get("password");

        return userService.loginUser(email, password);
    }

    // =============================
    // GET USER (Dashboard)
    // =============================
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // =============================
    // ATM WITHDRAW
    // =============================
    @PostMapping("/atm/withdraw/{id}")
    public User withdraw(@PathVariable String id, @RequestBody Transaction request) {

        return userService.withdrawMoney(id, request.getAmount());
    }

    // =============================
    // ATM DEPOSIT
    // =============================
    @PostMapping("/atm/deposit/{id}")
    public User deposit(@PathVariable String id, @RequestBody Transaction request) {

        return userService.depositMoney(id, request.getAmount());
    }

    // =============================
    // ATM CHANGE PIN
    // =============================
    @PostMapping("/atm/change-pin/{id}")
    public User changePin(@PathVariable String id, @RequestBody PinRequest request) {

        return userService.changePin(id, request.getNewPassword());
    }
}