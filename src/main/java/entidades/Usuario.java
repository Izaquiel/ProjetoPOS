/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquiel
 */
@Entity
@NamedQueries({@NamedQuery(name = "buscarUsuarioPorLogin", query = "Select u From Usuario u Where u.login= :login")})
public class Usuario implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    
    private String nome;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario( String nome, Date dataNascimento, String login, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Nome: "+ this.nome + " Login: " + this.login;
    }
    
    
    
}
