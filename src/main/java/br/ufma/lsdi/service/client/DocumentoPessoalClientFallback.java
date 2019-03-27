package br.ufma.lsdi.service.client;

import br.ufma.lsdi.model.auxiliar.CapabilityAuxiliar;
import br.ufma.lsdi.model.auxiliar.Data;
import br.ufma.lsdi.model.interscity.Capability;
import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.service.interscity.CapabilityClient;
import br.ufma.lsdi.service.neuro.DocumentoPessoalClient;
import org.springframework.stereotype.Component;

@Component
public class DocumentoPessoalClientFallback implements DocumentoPessoalClient {

    @Override
    public DocumentoPessoal saveDocumentoPessoal(DocumentoPessoal documentoPessoal) {
        return null;
    }
}
