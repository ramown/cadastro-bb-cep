package one.digitalinnovation.cadastro.entities;

import one.digitalinnovation.cadastro.entities.dtos.EnderecoDTO;
import one.digitalinnovation.cadastro.entities.dtos.Personagem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthday;
    private ArrayList<String> occupation;
    private String img;
    private String nickname;

    private String email;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(Long id, String name, String birthday, ArrayList<String> occupation, String img, String nickname, Endereco endereco, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.nickname = nickname;
        this.endereco = endereco;
        this.email = email;
    }

    public Usuario(Personagem dto, Endereco endereco, String email) {
        this.name = dto.getName();
        this.birthday = dto.getBirthday();
        this.occupation = dto.getOccupation();
        this.img = dto.getImg();
        this.nickname = dto.getNickname();
        this.endereco = endereco;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(ArrayList<String> occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
