package br.ufma.lsdi.model.neuro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sexo implements Serializable {

   private Long id;

    private String descricao;
}
