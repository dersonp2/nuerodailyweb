package br.ufma.lsdi.service.neuro;

import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.model.neuro.helper.PacienteHelper;
import br.ufma.lsdi.service.client.FeignInmateConfiguration;
import br.ufma.lsdi.service.client.PacienteClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "pacienteClient",
        url = "http://localhost:8090/paciente",
        configuration = FeignInmateConfiguration.class,
        fallback = PacienteClientFallback.class
)
public interface PacienteClient {

    @RequestMapping(method = RequestMethod.POST)
    Paciente savePaciente(@RequestBody PacienteHelper pacienteHelper);
}
