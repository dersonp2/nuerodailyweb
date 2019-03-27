package br.ufma.lsdi.service.neuro;

import br.ufma.lsdi.model.neuro.helper.PacienteHelper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "pacienteClient",
        url = "http://localhost:8090/paciente"
)
public interface PacienteClient {

    @RequestMapping(method = RequestMethod.POST)
    PacienteHelper savePaciente(@RequestBody PacienteHelper pacienteHelper);
}
