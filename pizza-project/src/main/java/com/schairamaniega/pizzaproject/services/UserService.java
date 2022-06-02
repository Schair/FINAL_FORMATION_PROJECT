package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.User;

public interface UserService {
    
    public List<User> findAll();

    public User findById(Long id);

    public String findNameById(Long id);

    public User save(User user);

}
