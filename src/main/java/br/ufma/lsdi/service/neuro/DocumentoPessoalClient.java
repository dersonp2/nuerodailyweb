package br.ufma.lsdi.service.neuro;

import br.ufma.lsdi.model.neuro.DocumentoPessoal;
import br.ufma.lsdi.service.client.CapabilityClientFallback;
import br.ufma.lsdi.service.client.DocumentoPessoalClientFallback;
import br.ufma.lsdi.service.client.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "documentoPessoalClient",
        url ="http://localhost:8090/documento_pessoal",
        fallback = DocumentoPessoalClientFallback.class,
        configuration = FeignConfiguration.class

)
public interface DocumentoPessoalClient {

    @RequestMapping(method = RequestMethod.POST)
    DocumentoPessoal saveDocumentoPessoal(@RequestBody DocumentoPessoal documentoPessoal);

}
