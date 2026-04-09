package com.f1.management.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDriverDTO {

    @NotBlank(message = "O nome do piloto é obrigatório")
    private String name;

    @NotBlank(message = "A nacionalidade do piloto é obrigatória")
    private String nationality;

    @NotNull(message = "O número do carro é obrigatório")
    @Min(value = 0, message = "O número deve ser entre 0 e 99")
    @Max(value = 99, message = "O número deve ser entre 0 e 99")
    private Integer number;

    @NotNull(message = "O id da equipe é obrigatório")
    private Long teamId;

    @NotBlank(message = "A categoria é obrigatória")
    private String category;

    @NotBlank(message = "A abreviação é obrigatória")
    @Size(min = 3, max = 3, message = "A abreviação deve ter exatamente 3 letras (Ex: HAM)")
    private String abreviacao;
}