package com.mayank.qna.qna_service.Services;

import com.mayank.qna.qna_service.DTOs.UserUpdateRequest;
import com.mayank.qna.qna_service.Entities.User;
import com.mayank.qna.qna_service.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No User Found"));
    }
    public User updateUser(Long id, UserUpdateRequest request){
       User user = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No User found for the given Id"));
       return userRepository.save(request.applyUpdates(user));
       //user modalMapper later here -
    }
}
