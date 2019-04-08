package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.model.interscity.Resource;
import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.model.neuro.Pessoa;
import br.ufma.lsdi.service.neuro.PacienteClient;
import br.ufma.lsdi.util.WebUtil;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.chart.LineChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@Scope("view")
@Component
public class VisualizarPaciente implements Serializable {


    @Autowired
    private PacienteClient pacienteClient;

    @Getter
    @Setter
    private boolean show;

    @Getter
    @Setter
    private String display;

    @Getter
    @Setter
    private Pessoa pessoa;
    @Getter
    @Setter
    private Paciente paciente;

    @PostConstruct
    public void init() {
        paciente = new Paciente();
        pessoa = new Pessoa();
        getObjetoFlashScope();
        show = false;
        display = "none";
    }


    public void getObjetoFlashScope() {

        if (WebUtil.flashScope().get("paciente") != null) {
            paciente = (Paciente) WebUtil.flashScope().get("paciente");

//            String[] data = paciente.getPessoa().getNascimento().split("-");
//
//            paciente.getPessoa().setNascimento(data[2] + "-" + data[1] + "-" + data[0]);

        } else {
            redirect();
        }

    }

    public void redirect() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "pretty:buscarPaciente";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public void showRendered() {
        if (show) {
            show = false;
            display = "none";
        } else {
            show = true;
            display = "block";
        }
    }

}
