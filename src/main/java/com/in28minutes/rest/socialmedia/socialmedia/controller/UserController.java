package com.in28minutes.rest.socialmedia.socialmedia.controller;

import com.in28minutes.rest.socialmedia.socialmedia.exceptionHandling.UserNotFoundException;
import com.in28minutes.rest.socialmedia.socialmedia.services.UserDaoService;
import com.in28minutes.rest.socialmedia.socialmedia.users.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {
    private final UserDaoService userService;

    public UserController(UserDaoService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();

    }
    @GetMapping("/users/{id}")
    public User retrieveSingleUsers(@PathVariable Integer id){
        var user = userService.findId(id);
        if(user==null)
            throw new UserNotFoundException("User Id: "+id+" Not Found");

        return user;
    }

    @DeleteMapping("/users/{id}")
    public void DeleteUser(@PathVariable Integer id){
         userService.deleteId(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        var savedUser = userService.saveUser(user);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
