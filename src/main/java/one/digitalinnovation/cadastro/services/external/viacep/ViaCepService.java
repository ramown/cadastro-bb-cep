package one.digitalinnovation.cadastro.services.external.viacep;

import one.digitalinnovation.cadastro.entities.dtos.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @see <a href="https://viacep.com.br/">ViaCEP</a>
 *
 */

@FeignClient(value = "cep-consumer", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    EnderecoDTO getEndereco(@PathVariable String cep);

}
