package com.fzg.repository;

import com.fzg.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface UserRepository {
    public Collection<User> findAll();
    public User findById(Integer id);
    public void saveOrUpdate(User user);
    public void deleteById(Integer id);
}
