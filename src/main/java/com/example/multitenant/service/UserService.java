package com.example.multitenant.service;

import com.example.multitenant.entity.User;
import com.example.multitenant.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() throws SQLException {
        return userRepository.findAll();

    }
}
