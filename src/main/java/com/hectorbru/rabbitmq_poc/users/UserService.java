package com.hectorbru.rabbitmq_poc.users;

import com.hectorbru.rabbitmq_poc.users.dtos.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(UserRequest request) {
        User user = new User(UUID.randomUUID(), request.name(), request.address());
        return userRepository.save(user);
    }
}
