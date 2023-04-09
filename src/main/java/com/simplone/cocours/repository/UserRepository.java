package com.simplone.cocours.repository;

import com.simplone.cocours.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

User findByCne(String cne);

}
