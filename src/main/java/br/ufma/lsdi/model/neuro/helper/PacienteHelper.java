package br.ufma.lsdi.model.neuro.helper;

import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.model.neuro.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
public class PacienteHelper implements Serializable {

    private Paciente paciente;
    private DocumentoPessoal documentoPessoal;
    private DocumentoPessoal documentoPessoalResponsavel;

}
