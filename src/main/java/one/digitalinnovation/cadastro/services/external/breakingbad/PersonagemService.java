package one.digitalinnovation.cadastro.services.external.breakingbad;

import one.digitalinnovation.cadastro.entities.dtos.Personagem;
import one.digitalinnovation.cadastro.services.external.breakingbad.BreakingBadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private BreakingBadService breakingBadService;

    public Optional<Personagem> getPersonagem(String nome) {
        List<Personagem> personagem = breakingBadService.getPersonagem(nome);
        if (personagem.size() > 0) return Optional.of(personagem.get(0));
        return Optional.empty();
    }
}
