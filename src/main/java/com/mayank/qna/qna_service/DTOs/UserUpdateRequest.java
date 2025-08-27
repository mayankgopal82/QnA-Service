package com.mayank.qna.qna_service.DTOs;

import com.mayank.qna.qna_service.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String userName;
    private String email;
    private String bio;

    public User applyUpdates(User user){
        if(this.getBio()!=null){
            user.setBio(this.getBio());
        }
        if(this.getEmail()!=null){
            user.setEmail(this.getEmail());
        }
        if(this.getUserName()!=null){
            user.setUsername(this.getUserName());
        }
        return user;
    }
}
