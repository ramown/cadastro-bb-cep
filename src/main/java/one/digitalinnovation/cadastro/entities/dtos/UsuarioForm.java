package one.digitalinnovation.cadastro.entities.dtos;

public class UsuarioForm {

    private String nome;
    private String cep;
    private String email;

    public UsuarioForm() {
    }

    public UsuarioForm(String nome, String cep, String email) {
        this.nome = nome;
        this.cep = cep;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UsuarioForm{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cep='").append(cep).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
