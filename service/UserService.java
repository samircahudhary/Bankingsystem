package com.bank.bank_backend.service;

import com.bank.bank_backend.model.User;
import com.bank.bank_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // =============================
    // REGISTER
    // =============================
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // =============================
    // LOGIN
    // =============================
    public User loginUser(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();

        if (user.getPassword() == null) {
            throw new RuntimeException("Password not set");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    // =============================
    // GET USER
    // =============================
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // =============================
    // ATM WITHDRAW
    // =============================
    public User withdrawMoney(String id, double amount) {

        User user = getUserById(id);

        if (user.getTotalBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        user.setTotalBalance(user.getTotalBalance() - amount);

        return userRepository.save(user);
    }

    // =============================
    // ATM DEPOSIT
    // =============================
    public User depositMoney(String id, double amount) {

        User user = getUserById(id);

        user.setTotalBalance(user.getTotalBalance() + amount);

        return userRepository.save(user);
    }

    // =============================
    // CHANGE PIN
    // =============================
    public User changePin(String id, String newPassword) {

        User user = getUserById(id);

        user.setPassword(newPassword);

        return userRepository.save(user);
    }
}