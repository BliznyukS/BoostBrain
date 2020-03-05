package com.boost.brain.http.service;

import com.boost.brain.http.entity.User;
import com.boost.brain.http.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser (String userName) {
        return userRepository.save(new User(userName));
    }
}
