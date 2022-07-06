package com.fzg.controller;

import com.fzg.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<User> findAll(){
        return restTemplate.getForObject("http://localhost:8080/user/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return restTemplate.getForObject("http://localhost:8080/user/findById/{id}",User.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        restTemplate.postForObject("http://localhost:8080/user/save",user,Collection.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        restTemplate.put("http://localhost:8080/user/update",user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        restTemplate.delete("http://localhost:8080/user/deleteById/{id}",id);
    }
}
