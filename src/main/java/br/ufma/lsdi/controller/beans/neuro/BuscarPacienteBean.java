package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.service.neuro.PacienteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@Scope("view")
public class BuscarPacienteBean {




    @Autowired
    private PacienteClient pacienteClient;

    @PostConstruct
    public void init() {

    }



}
