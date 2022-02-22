package one.digitalinnovation.cadastro.services.external.breakingbad;

import one.digitalinnovation.cadastro.entities.dtos.Personagem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @see <a href="https://www.breakingbadapi.com/">The Breaking Bad API</a>
 *
 */

@FeignClient(value = "personagem-consumer", url = "https://breakingbadapi.com/api/characters")
public interface BreakingBadService {

    @GetMapping
    List<Personagem> getPersonagem(@RequestParam String name);

}
