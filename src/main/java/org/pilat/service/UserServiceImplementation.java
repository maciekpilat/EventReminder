/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.service;

import java.util.List;
import org.pilat.model.User;
import org.pilat.repository.UserRepository;

/**
 *
 * @author Pilat
 */
public class UserServiceImplementation implements UserService {

    UserRepository ur;

    public void saveUser(User u) {

        System.out.println("Zapisuje!");
        ur.save(u);
        System.out.println("Zapisałem!");

    }

    public void deleteUserById(long id) {

        ur.delete(id);

    }

    public User findUserById(long id) {
        User u = ur.findOne(id);

        return u;
    }

    public List<User> findAllUsers() {

        return (List<User>) ur.findAll();
    }

}
