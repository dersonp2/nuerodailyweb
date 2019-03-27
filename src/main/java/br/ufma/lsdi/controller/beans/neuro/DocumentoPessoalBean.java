package br.ufma.lsdi.controller.beans.neuro;

import br.ufma.lsdi.model.interscity.Resource;
import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.model.neuro.Pessoa;
import br.ufma.lsdi.model.neuro.Sexo;
import br.ufma.lsdi.service.neuro.DocumentoPessoalClient;
import br.ufma.lsdi.util.WebUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Controller
@Scope("View")
public class DocumentoPessoalBean {

    private DocumentoPessoalClient documentoPessoalClient;

    private DocumentoPessoal documentoPessoal;

    public DocumentoPessoalBean(DocumentoPessoalClient documentoPessoalClient) {
        this.documentoPessoalClient = documentoPessoalClient;
    }

    @PostConstruct
    public void init() {
        documentoPessoal = new DocumentoPessoal();
    }

    public void salvar() {
        Sexo sexo = new Sexo();
        sexo.setId((long) 2);
        Pessoa  pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setSexo(sexo);
        documentoPessoal.setCpf("11111111");
        documentoPessoal.setRg("22222222");
        documentoPessoal.setSus("333333");
        documentoPessoal.setPessoa(pessoa);
        DocumentoPessoal documentoPessoalRetorno =
                documentoPessoalClient.saveDocumentoPessoal(documentoPessoal);
        if (documentoPessoalRetorno != null) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(WebUtil.DADOS_SALVO));
            documentoPessoal = new DocumentoPessoal();
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(WebUtil.ERROR_SALVAR));
        }
    }

}
