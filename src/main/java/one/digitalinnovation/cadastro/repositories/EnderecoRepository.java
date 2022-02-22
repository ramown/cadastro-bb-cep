package one.digitalinnovation.cadastro.repositories;

import one.digitalinnovation.cadastro.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findByCep(String cep);
}
