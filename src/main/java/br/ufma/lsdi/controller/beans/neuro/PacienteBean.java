package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.model.neuro.helper.PacienteHelper;
import br.ufma.lsdi.service.neuro.PacienteClient;
import br.ufma.lsdi.util.WebUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Controller
@Scope("View")
public class PacienteBean {

    private PacienteClient pacienteClient;

    private PacienteHelper pacienteHelper;


    public PacienteBean(PacienteClient pacienteClient) {
        this.pacienteClient = pacienteClient;
    }

    @PostConstruct
    public void init() {
        pacienteHelper = new PacienteHelper();
    }

    public void savePaciente() {
        PacienteHelper helper = pacienteClient.savePaciente(pacienteHelper);

        if (helper != null) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(WebUtil.DADOS_SALVO));
            pacienteHelper = new PacienteHelper();
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(WebUtil.ERROR_SALVAR));
        }
    }

    public PacienteHelper getPacienteHelper() {
        return pacienteHelper;
    }

    public void setPacienteHelper(PacienteHelper pacienteHelper) {
        this.pacienteHelper = pacienteHelper;
    }
}