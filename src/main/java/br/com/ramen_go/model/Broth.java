package br.com.ramen_go.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_broths")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Broth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageInactive;
    private String imageActive;
    private String name;

    private String description;
    private BigDecimal price;

}
