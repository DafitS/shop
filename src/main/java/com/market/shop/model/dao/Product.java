package com.market.shop.model.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "products", schema = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    private UUID id;

    private String name;
    private BigDecimal price;
    private Long quantity;
    private String serialNumber;
    private Boolean active;
}
