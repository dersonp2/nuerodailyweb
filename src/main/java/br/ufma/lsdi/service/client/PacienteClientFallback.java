package br.ufma.lsdi.service.client;

import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.model.neuro.helper.PacienteHelper;
import br.ufma.lsdi.service.neuro.DocumentoPessoalClient;
import br.ufma.lsdi.service.neuro.PacienteClient;
import org.springframework.stereotype.Component;

@Component
public class PacienteClientFallback implements PacienteClient {


    @Override
    public Paciente savePaciente(PacienteHelper pacienteHelper) {
        return null;
    }
}
