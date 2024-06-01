package br.com.ramen_go.dtos;

import java.math.BigDecimal;

public record ProteinResponseDto(
        Long id,
        String imageInactive,
        String imageActive,
        String name,

        String description,
        BigDecimal price
) {
}
