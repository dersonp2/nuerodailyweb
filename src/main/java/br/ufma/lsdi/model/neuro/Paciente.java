package br.ufma.lsdi.model.neuro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente implements Serializable{
    private Long id;

    private String dataCadastro;

    private String matricula;

    private Pessoa pessoa;

    private Pessoa responsavel;

}
