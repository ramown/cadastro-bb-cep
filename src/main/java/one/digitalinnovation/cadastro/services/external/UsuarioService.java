package one.digitalinnovation.cadastro.services.external;

import one.digitalinnovation.cadastro.entities.Endereco;
import one.digitalinnovation.cadastro.entities.Usuario;
import one.digitalinnovation.cadastro.entities.dtos.Personagem;
import one.digitalinnovation.cadastro.repositories.UsuarioRepository;
import one.digitalinnovation.cadastro.services.exceptions.EntityAlreadyExistsException;
import one.digitalinnovation.cadastro.services.exceptions.EntityNotFoundException;
import one.digitalinnovation.cadastro.services.external.breakingbad.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private PersonagemService personagemService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario getUsuarioByEmail(String email){
        return usuarioRepository.findByEmail(email).get();
    }

    public Optional<Usuario> cadastrarUsuario(String nome, String cep, String email) {
        Endereco endereco = getEndereco(cep).orElseThrow(() -> new EntityNotFoundException("Cep not found: " + cep));
        Personagem personagem = getPersonagem(nome).orElseThrow(() -> new EntityNotFoundException("Name not found: " + nome));

        if (usuarioExists(email)) {
            throw new EntityAlreadyExistsException("Email já foi cadastrado: <" + nome + "> " + email);
        }

        Usuario usuario = new Usuario(personagem, endereco, email);
        boolean status = saveUsuario(usuario);

        if(status) return Optional.of(usuario);

        return Optional.empty();
    }

    private boolean saveUsuario(Usuario usuario) {
        if(!usuarioExists(usuario.getEmail())){
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    private Optional<Endereco> getEndereco(String cep){
        return enderecoService.getEndereco(cep);
    }

    private Optional<Personagem> getPersonagem(String nome){
        return personagemService.getPersonagem(nome);
    }

    private boolean usuarioExists(String email) {
        if (usuarioRepository.findByEmail(email).isPresent()) return true;
        return false;
    }

}
