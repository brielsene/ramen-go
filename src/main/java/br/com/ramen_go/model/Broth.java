package br.com.ramen_go.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_broths")
public class Broth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String imageInactive;
    private String imageActive;
    private String name;

    private String description;
    private BigDecimal price;

}
