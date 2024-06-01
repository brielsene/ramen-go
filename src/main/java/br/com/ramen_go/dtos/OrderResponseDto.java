package br.com.ramen_go.dtos;

public record OrderResponseDto(
        Long id,
        String description,
        String image
) {
}
