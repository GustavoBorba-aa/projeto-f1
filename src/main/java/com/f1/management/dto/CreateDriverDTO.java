package com.f1.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // getters
@Setter // setters
@NoArgsConstructor // construtor vazio
@AllArgsConstructor // contrutor com os atributos
public class CreateDriverDTO {
    @NotBlank(message = "O nome do piloto é obrigatório")
    private String name;
    @NotBlank(message = "O nome do piloto é obrigatório")
    private String nationality;
    @NotNull(message = "O numero do carro não pode ser vazio")
    private Integer number;
    @NotNull(message = "O id da equipe não pode estar vazio")
    private Long teamId;
    @NotBlank(message = "A categoria é obrigatório")
    private String category;
    @NotBlank(message = "A abreviação do Piloto não pode estar vazia")
    private String abreviacao;
}