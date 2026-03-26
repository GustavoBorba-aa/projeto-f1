package com.f1.management.dto;

import com.f1.management.model.Team;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarDTO {

    @NotBlank(message = "O nome do modelo do carro é obrigatório")
    private String modelCar;
    @NotNull(message = "O id da equipe não pode estar vazio")
    private Long teamId;
}
