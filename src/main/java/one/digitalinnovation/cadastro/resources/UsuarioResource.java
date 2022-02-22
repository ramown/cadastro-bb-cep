package one.digitalinnovation.cadastro.resources;

import one.digitalinnovation.cadastro.entities.Usuario;
import one.digitalinnovation.cadastro.entities.dtos.Personagem;
import one.digitalinnovation.cadastro.entities.dtos.UsuarioForm;
import one.digitalinnovation.cadastro.services.UsuarioSistemaService;
import one.digitalinnovation.cadastro.services.external.breakingbad.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioSistemaService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getUsuario(id);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody UsuarioForm usuarioForm){
        String nome = usuarioForm.getNome(), cep = usuarioForm.getCep(), email = usuarioForm.getEmail();

        Usuario usuario = usuarioService.cadastrarUsuario(nome, cep, email);
        return usuario;
    }
}
