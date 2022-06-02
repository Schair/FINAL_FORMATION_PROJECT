package com.schairamaniega.pizzaproject.services;

import java.util.List;

import com.schairamaniega.pizzaproject.dao.CommentDAO;
import com.schairamaniega.pizzaproject.entities.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> findAll() {
        return this.commentDAO.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return this.commentDAO.save(comment);
    }
    
}
