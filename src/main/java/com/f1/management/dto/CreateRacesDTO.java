package com.f1.management.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRacesDTO {
    @NotBlank(message = "O nome do circuto é obrigatório")
    private String nameCircuit;
    @NotBlank(message = "O nome do Grande Prêmio é obrigatório")
    private String grandPrixName;
    @NotNull(message = "A data da corrida é obrigatória")
    @Future(message = "A data da corrida deve ser uma data futura")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate raceDate;

}