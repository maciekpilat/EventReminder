/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.repository;

import org.springframework.data.repository.CrudRepository;
import org.pilat.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pilat
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
  
    @Query("select u.userLogin from User u where u.userLogin = :login")
    public User findUserByLogin (String login);
    
}