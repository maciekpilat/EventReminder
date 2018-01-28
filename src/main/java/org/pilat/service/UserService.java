/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.service;

import java.util.List;
import org.pilat.model.User;

/**
 *
 * @author Pilat
 */
public interface UserService {
    
public void saveUser(User u);

public void deleteUserById(long id);

public User findUserById(long id);

public List<User> findAllUsers();
    
}
