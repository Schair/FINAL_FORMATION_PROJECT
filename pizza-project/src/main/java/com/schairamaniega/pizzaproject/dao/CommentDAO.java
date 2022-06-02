package com.schairamaniega.pizzaproject.dao;

import com.schairamaniega.pizzaproject.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Long>{
    
}
