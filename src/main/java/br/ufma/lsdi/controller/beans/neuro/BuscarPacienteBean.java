package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.service.neuro.PacienteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@Scope("view")
public class BuscarPacienteBean {

    private PacienteClient pacienteClient;

    List<Paciente> pacientes;

    public BuscarPacienteBean(PacienteClient pacienteClient) {
        this.pacienteClient = pacienteClient;
    }

    @PostConstruct
    public void init() {

    }

    public void  buscarPacientes(String nome){
            pacientes = pacienteClient.getPacienteNome(nome);
    }
}
