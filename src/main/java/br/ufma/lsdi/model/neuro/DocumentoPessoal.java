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
public class DocumentoPessoal implements Serializable {
    private Long id;
    private String cpf;

    private String rg;

    private String sus;

    private Date data;

    private Pessoa pessoa;

}
