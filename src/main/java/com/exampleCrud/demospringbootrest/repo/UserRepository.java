package com.exampleCrud.demospringbootrest.repo;

import com.exampleCrud.demospringbootrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {       //JpaRepository<User, Long> -  type of JPA Entity & type of primary key






}


