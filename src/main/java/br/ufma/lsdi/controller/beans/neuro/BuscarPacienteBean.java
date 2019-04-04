package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.model.neuro.Pessoa;
import br.ufma.lsdi.service.neuro.PacienteClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@Scope("view")
public class BuscarPacienteBean {

    private Paciente paciente;
    @Autowired
    private PacienteClient pacienteClient;
    private Pessoa pessoa;

    List<Paciente> pacientes;


    public BuscarPacienteBean(PacienteClient pacienteClient) {
        this.pacienteClient = pacienteClient;
    }

    @PostConstruct
    public void init() {
        initObjects();
    }


    public void initObjects(){
        pacientes = new ArrayList<Paciente>();
        paciente = new Paciente();
        pessoa = new Pessoa();
    }

    public void searchPacienteByNome(){
        if(pessoa.getNome() != null){
            pacientes = pacienteClient.getPacienteNome(pessoa.getNome());
        }
    }
}
