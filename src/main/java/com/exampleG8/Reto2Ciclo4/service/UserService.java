/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto2Ciclo4.service;

import com.exampleG8.Reto2Ciclo4.model.User;
import com.exampleG8.Reto2Ciclo4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author raque
 */
@Service
public class UserService {
    /**
     * Instancia de Repositorio
     */
    @Autowired
    private UserRepository UserRepo;
    
    /**
     * Método Listar todos los usuarios
     * @return 
     */
    public List<User> getAll(){
        return UserRepo.getAll();
    }
    
    /**
     * Método consultar usuario por ID
     * @param id
     * @return 
     */
    public Optional<User> getById(Integer id){
        return UserRepo.getById(id);
    }
      
    /**
     * Consultar email existente
     * @param email
     * @return 
     */
    public boolean existsEmail(String email){
        return UserRepo.existsEmail(email);
    }
    
    /**
     * Consultar combinación email/contraseña
     * @param email
     * @param password
     * @return 
     */
    public User loginUser(String email, String password){
        Optional <User> usuario = UserRepo.getEmailAndPass(email, password);
        if(usuario.isEmpty()){
            return new User();
        }else{
            return usuario.get();
        }
        
    }
    
    /**
     * Método Crear usuario
     * @param user
     * @return 
     */
    public User save(User user){
        
        if(user.getId() == null){
            return user;
        } else {
            Optional <User> evt = UserRepo.getById(user.getId());
            if(evt.isEmpty()){
                if(existsEmail(user.getEmail()) == false){
                    return UserRepo.save(user);
                } else {
                    return user;
                }  
            } else {
                return user;
            }
        } 
    }
    
    /**
     * Método Actualizar Usuario
     * @param user
     * @return 
     */
    public User update(User user){
//        Optional<User> existUser = getById(user.getId());
//        if (existUser.isEmpty()){
//            return user;
//        }
//        return UserRepo.save(user);

          if(user.getId() != null){
              
              Optional <User> existUser = UserRepo.getById(user.getId());
              if(!existUser.isEmpty()){
                  if(user.getIdentification() != null){
                      existUser.get().setIdentification(user.getIdentification());
                  }
                  if(user.getName() != null){
                      existUser.get().setName(user.getName());
                  }
                  if(user.getAddress() != null){
                      existUser.get().setAddress(user.getAddress());
                  }
                  if(user.getCellPhone() != null){
                      existUser.get().setCellPhone(user.getCellPhone());
                  }
                  if(user.getEmail() != null){
                      existUser.get().setEmail(user.getEmail());
                  }
                  if(user.getPassword() != null){
                      existUser.get().setPassword(user.getPassword());
                  }
                  if(user.getZone() != null){
                      existUser.get().setZone(user.getZone());
                  }
                  if(user.getType() != null){
                      existUser.get().setType(user.getType());
                  }
                  
                  UserRepo.save(existUser.get());
                  return existUser.get();
              } else{
                  return user;
              } 
   
          } else {
              return user;
          }
          
    }
    
    /**
     * Método Eliminar usuario por ID
     * @param id 
     */
    public void delete(Integer id){
        
        UserRepo.delete(id);
    }
}
