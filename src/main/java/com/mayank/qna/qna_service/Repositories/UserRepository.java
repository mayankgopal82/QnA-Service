package com.mayank.qna.qna_service.Repositories;

import com.mayank.qna.qna_service.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String username);
}
