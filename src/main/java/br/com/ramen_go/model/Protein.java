package br.com.ramen_go.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_proteins")
public class Protein {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private BigDecimal price;
}
