package com.fzg.controller;

import com.fzg.entity.User;
import com.fzg.repository.UserRepository;
import com.fzg.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public Collection<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.saveOrUpdate(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userRepository.saveOrUpdate(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
}
