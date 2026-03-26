package com.f1.management.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateResultsDTO {

    @NotNull(message = "O ID da corrida é obrigatório")
    private Long raceId;

    @NotNull(message = "O ID do piloto é obrigatório")
    private Long driverId;

    @NotNull(message = "A posição de chegada é obrigatória")
    @Min(value = 1, message = "A posição mínima é 1")
    @Max(value = 22, message = "A posição máxima é 22 (limite do grid)")
    private Integer position;

    @NotNull(message = "A pontuação obtida é obrigatória")
    @PositiveOrZero(message = "Os pontos não podem ser negativos")
    private Double pointsEarned;
}