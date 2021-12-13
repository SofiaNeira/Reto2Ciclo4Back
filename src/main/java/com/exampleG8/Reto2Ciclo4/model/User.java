/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exampleG8.Reto2Ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author raque
 */
@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
 

    @Id
    private Integer id;
    private String identification;
    private String name;
    //private Date birthtDay;
    //private String monthBirthtDay;
    private String address;
    private String cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;
}
