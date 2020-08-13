package com.zict.fourthde.repository;


import com.zict.fourthde.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);


}