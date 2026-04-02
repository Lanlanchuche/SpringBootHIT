package com.example.demo.service;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> findAll(){
        return users;
    }

    public User findById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public User create(CreateUserRequest createUserRequest){
        boolean emailExists = users.stream().anyMatch(user -> user.getEmail().equals(createUserRequest.getEmail()));
        if(emailExists){
            throw new DuplicateResourceException("User", "email", createUserRequest.getEmail());
        }
        User user = new User();
        user.setId(this.nextId++);
        user.setName(createUserRequest.getName());
        user.setEmail(createUserRequest.getEmail());
        user.setAge(createUserRequest.getAge());
        users.add(user);
        return user;
    }
    public void delete(Long id){
        User user = findById(id);
        users.remove(user);
    }

}
