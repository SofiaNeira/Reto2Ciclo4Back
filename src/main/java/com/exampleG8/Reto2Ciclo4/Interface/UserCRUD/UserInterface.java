/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto2Ciclo4.Interface.UserCRUD;

import com.exampleG8.Reto2Ciclo4.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author raque
 */
public interface UserInterface extends MongoRepository <User, Integer>{
    Optional <User> findByEmail(String email);
    
    Optional <User> findEmailAndPasswordByEmailAndPassword(String email, String password);
    
}
