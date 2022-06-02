package com.schairamaniega.pizzaproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schairamaniega.pizzaproject.dao.UserDAO;
import com.schairamaniega.pizzaproject.entities.User;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return this.userDAO.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userDAO.findById(id).get();
    }

    @Override
    public String findNameById(Long id) {
        return this.userDAO.findById(id).get().getName();
    }

    @Override
    public User save(User user) {
        return this.userDAO.save(user);
    }


}
