package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.entities.Comment;

public interface CommentService {

    public List<Comment> findAll();

    public Comment save(Comment comment);

}
