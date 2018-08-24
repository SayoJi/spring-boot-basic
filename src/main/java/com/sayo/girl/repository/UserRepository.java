package com.sayo.girl.repository;

import com.sayo.girl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserId(String userId);
}
