package com.exampleCrud.demospringbootrest.service.impl;


import com.exampleCrud.demospringbootrest.entity.User;
import com.exampleCrud.demospringbootrest.repo.UserRepository;
import com.exampleCrud.demospringbootrest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser= userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User exsistingUser = userRepository.findById(user.getId()).get();
        exsistingUser.setFirstName(user.getFirstName());
        exsistingUser.setLastName(user.getLastName());
        exsistingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(exsistingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
