package br.ufma.lsdi.model.neuro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {
   private Long id;

    private String nome;

    private Date nascimento;

    private Sexo sexo;

}
