package one.digitalinnovation.cadastro.services;

import one.digitalinnovation.cadastro.entities.Endereco;
import one.digitalinnovation.cadastro.entities.Usuario;
import one.digitalinnovation.cadastro.entities.dtos.Personagem;
import one.digitalinnovation.cadastro.services.exceptions.EntityNotFoundException;
import one.digitalinnovation.cadastro.services.external.EnderecoService;
import one.digitalinnovation.cadastro.services.external.UsuarioService;
import one.digitalinnovation.cadastro.services.external.breakingbad.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSistemaService {

    @Autowired
    private UsuarioService usuarioService;

    public Usuario cadastrarUsuario(String nome, String cep, String email) {
        Optional<Usuario> usuario = usuarioService.cadastrarUsuario(nome, cep, email);

        return usuarioService.getUsuarioByEmail(email);
    }

    public Usuario getUsuario(Long id) {
        return usuarioService.getUsuario(id).orElseThrow(() -> new EntityNotFoundException("Id not found: " + id));
    }

    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }


}
