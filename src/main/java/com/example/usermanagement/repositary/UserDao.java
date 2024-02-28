package com.example.usermanagement.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagement.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Long>{

}
