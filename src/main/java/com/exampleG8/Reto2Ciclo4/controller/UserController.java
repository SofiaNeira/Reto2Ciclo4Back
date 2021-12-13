/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto2Ciclo4.controller;

import com.exampleG8.Reto2Ciclo4.model.User;
import com.exampleG8.Reto2Ciclo4.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author raque
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {
    
    @Autowired
    private UserService UserService;
    
    @GetMapping("/all")
    public List<User> list() {
        return UserService.getAll();
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return UserService.getById(id).orElse(null);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean existsEmail(@PathVariable("email") String email){
        return UserService.existsEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User loginUser(@PathVariable String email, @PathVariable String password){
        return UserService.loginUser(email, password);
    }
    
//    @PostMapping("/new")
//    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        User newUser = UserService.save(user);
//        
//        return new ResponseEntity(newUser, HttpStatus.CREATED);
//    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        
        return UserService.save(user);
        
    }
    
//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        
//        User upUser = UserService.update(user);
//        
//        return new ResponseEntity(upUser, HttpStatus.OK);
//    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return UserService.update(user);
    }
    
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  delete(@PathVariable Integer id) {
        
        UserService.delete(id);
        
//        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
