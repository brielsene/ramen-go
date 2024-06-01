package br.com.ramen_go.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    private Long id;
    private String descrption;

    private String image;

}
