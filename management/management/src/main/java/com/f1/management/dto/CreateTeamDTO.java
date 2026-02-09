package com.f1.management.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamDTO {

    @NotBlank(message = "O nome da equipe é obrigatório")
    private String name;

    @NotBlank(message = "O país de origem é obrigatório")
    private String country;

    @NotBlank(message = "O fornecedor de motor é obrigatório")
    private String engine;

    @NotNull(message = "O ano de fundação é obrigatório")
    @Min(value = 1950, message = "O ano de fundação não pode ser anterior ao início da F1 (1950)")
    @Max(value = 2026, message = "O ano de fundação não pode ser no futuro")
    private Integer foundationYear;

    @NotBlank(message = "A sede da equipe é obrigatória")
    private String sedeDaEquipe;

    @NotBlank(message = "O nome do chefe de equipe é obrigatório")
    private String chefeDeEquipe;
}