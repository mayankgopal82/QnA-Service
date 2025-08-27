package com.mayank.qna.qna_service.Controllers;

import com.mayank.qna.qna_service.DTOs.UserUpdateRequest;
import com.mayank.qna.qna_service.Entities.User;
import com.mayank.qna.qna_service.Services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    ResponseEntity<User> registerUser(@RequestBody User user){
        User responseBody = userService.registerUser(user);
      return  ResponseEntity.status(201).body(responseBody);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest request){
       User user= userService.updateUser(id,request);
       return ResponseEntity.ok(user);
    }

}
