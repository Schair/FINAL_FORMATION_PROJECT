package com.schairamaniega.pizzaproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.schairamaniega.pizzaproject.entities.Comment;
import com.schairamaniega.pizzaproject.services.CommentService;
import com.schairamaniega.pizzaproject.services.PizzaService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/details")
@RequiredArgsConstructor
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PizzaService pizzaService;

    // @Transactional
    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping(value = "/{pizza_id}")
    public ResponseEntity<String> save(ModelMap map, HttpServletRequest request, @PathVariable(name = "pizza_id") long pizza_id, @ModelAttribute Comment comment){

        
        // comment.setPizza(pizzaService.findById(pizza_id));

        System.out.println(comment);
        System.out.println(pizza_id);

        try {
            commentService.save(new Comment().builder().body(comment.getBody()).user(comment.getUser()).score(comment.getScore()).pizza(pizzaService.findById(pizza_id)).build());
        } catch (Exception e) {
            return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("Success", HttpStatus.CREATED);
    }
    
}
