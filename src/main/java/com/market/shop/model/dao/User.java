package com.market.shop.model.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users", schema = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean active;

}
