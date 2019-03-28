package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.model.neuro.Pessoa;
import br.ufma.lsdi.model.neuro.Sexo;
import br.ufma.lsdi.model.neuro.helper.PacienteHelper;
import br.ufma.lsdi.service.neuro.PacienteClient;
import br.ufma.lsdi.util.WebUtil;
import org.primefaces.component.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("view")
public class PacienteBean {

    @Autowired
    private PacienteClient pacienteClient;

    private Pessoa pessoa;
    private Pessoa responsavel;
    private DocumentoPessoal documentoPessoal;
    private DocumentoPessoal documentoPessoalResponsavel;
    private Paciente paciente;
    private Sexo sexo;
    private Sexo sexoResponsavel;

    private List<Sexo> sexos;

    public PacienteBean(PacienteClient pacienteClient) {
        this.pacienteClient = pacienteClient;
    }

    @PostConstruct
    public void init() {
        iniciarObj();
        carregarSexo();
    }

    public void iniciarObj() {
        pessoa = new Pessoa();
        responsavel = new Pessoa();
        documentoPessoal = new DocumentoPessoal();
        documentoPessoalResponsavel = new DocumentoPessoal();
        paciente = new Paciente();
        sexo = new Sexo();
        sexoResponsavel = new Sexo();

        sexos = new ArrayList<>();
    }

    public void savePaciente() {
        PacienteHelper pacienteHelper = new PacienteHelper();
        if (validarCampos()) {
            pessoa.setSexo(sexo);
            paciente.setPessoa(pessoa);
            responsavel.setSexo(sexoResponsavel);
            paciente.setResponsavel(responsavel);
            documentoPessoal.setPessoa(pessoa);
            documentoPessoalResponsavel.setPessoa(responsavel);

            pacienteHelper.setPaciente(paciente);
            pacienteHelper.setDocumentoPessoal(documentoPessoal);
            pacienteHelper.setDocumentoPessoalResponsavel(documentoPessoalResponsavel);
            try {

                paciente = pacienteClient.savePaciente(pacienteHelper);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(paciente != null && paciente.getId() != null){

            }
        }
    }

    public boolean validarCampos() {
        if (pessoa.getNome() == null) {
            //colocar grow (metodo)
            return false;
        }

        if (responsavel.getNome() == null) {
            return false;
        }

        if (documentoPessoal.getCpf() == null) {
            return false;
        }

        if (documentoPessoalResponsavel.getCpf() == null) {
            return false;
        }

        if (sexo.getId() == null) {
            return false;
        }

        if (sexoResponsavel.getId() == null) {
            return false;
        }

        return true;
    }

    public void carregarSexo() {
        sexos.add(new Sexo(1L, "Masculino"));
        sexos.add(new Sexo(2L, "Feminino"));
    }

    public PacienteClient getPacienteClient() {
        return pacienteClient;
    }

    public void setPacienteClient(PacienteClient pacienteClient) {
        this.pacienteClient = pacienteClient;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public DocumentoPessoal getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(DocumentoPessoal documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    public DocumentoPessoal getDocumentoPessoalResponsavel() {
        return documentoPessoalResponsavel;
    }

    public void setDocumentoPessoalResponsavel(DocumentoPessoal documentoPessoalResponsavel) {
        this.documentoPessoalResponsavel = documentoPessoalResponsavel;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Sexo getSexoResponsavel() {
        return sexoResponsavel;
    }

    public void setSexoResponsavel(Sexo sexoResponsavel) {
        this.sexoResponsavel = sexoResponsavel;
    }

    public List<Sexo> getSexos() {
        return sexos;
    }
}
