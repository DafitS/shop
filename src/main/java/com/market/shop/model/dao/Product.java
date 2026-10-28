package com.market.shop.model.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products", schema = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    private String name;
    private BigDecimal price;
    private Long quantity;
    private String serialNumber;//poprawic pod ean i funkcja w popstgress pod ean
    private Boolean active;
}
