package br.ufma.lsdi.model.neuro.helper;

import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.model.neuro.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteHelper implements Serializable {

    private Paciente paciente;
    private DocumentoPessoal documentoPessoal;
    private DocumentoPessoal documentoPessoalResponsavel;
    // private List<PessoaContato> pessoaContatos;

}
