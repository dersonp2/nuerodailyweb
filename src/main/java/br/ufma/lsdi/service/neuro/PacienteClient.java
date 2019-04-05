package br.ufma.lsdi.service.neuro;

import br.ufma.lsdi.model.neuro.Paciente;
import br.ufma.lsdi.model.neuro.helper.PacienteHelper;
import br.ufma.lsdi.service.client.FeignInmateConfiguration;
import br.ufma.lsdi.service.client.PacienteClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "pacienteClient",
        //url = "http://sishomol.seap.ma.gov.br:8080/neurodaily-1.0/paciente",
        url ="http://localhost:8090/paciente",
        configuration = FeignInmateConfiguration.class,
        fallback = PacienteClientFallback.class
)
public interface PacienteClient {

    @RequestMapping(method = RequestMethod.POST)
    Paciente savePaciente(@RequestBody PacienteHelper pacienteHelper);

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Paciente getPaciente(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/nome/{nome}")
    List<Paciente> getPacienteNome(@PathVariable("nome") String nome);

    @RequestMapping(method = RequestMethod.GET)
    List<Paciente> getPacientes();
}
