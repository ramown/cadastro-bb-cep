package one.digitalinnovation.cadastro.services.external;

import one.digitalinnovation.cadastro.entities.Endereco;
import one.digitalinnovation.cadastro.entities.dtos.EnderecoDTO;
import one.digitalinnovation.cadastro.repositories.EnderecoRepository;
import one.digitalinnovation.cadastro.services.external.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Optional<Endereco> getEndereco(String cep){

        if (getEnderecoByCep(cep).isEmpty()){
            EnderecoDTO dto = getEnderecoViaCep(cep);
            Endereco obj = new Endereco(dto);
            Endereco endereco = enderecoRepository.save(obj);
            return Optional.of(endereco);
        }

        return Optional.empty();
    }

    private EnderecoDTO getEnderecoViaCep(String cep) {
        return viaCepService.getEndereco(cep);
    }

    private Optional<Endereco> getEnderecoByCep(String cep){
        Endereco endereco = enderecoRepository.findByCep(cep);

        if (endereco != null) return Optional.of(endereco);
        return Optional.empty();
    }

}
