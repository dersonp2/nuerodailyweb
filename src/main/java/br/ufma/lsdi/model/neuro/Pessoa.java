package br.ufma.lsdi.model.neuro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pessoa implements Serializable {

    private Long id;
    private String nome;
    private LocalDate nascimento;
    private Sexo sexo;

}
