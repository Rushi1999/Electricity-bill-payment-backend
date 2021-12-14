package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

  public abstract User findByUserName(String userName);
  


  


}