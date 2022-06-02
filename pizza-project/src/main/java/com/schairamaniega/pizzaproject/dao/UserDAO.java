package com.schairamaniega.pizzaproject.dao;

import com.schairamaniega.pizzaproject.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
    
}
