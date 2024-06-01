package br.com.ramen_go.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_proteins")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Protein {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private BigDecimal price;
}
