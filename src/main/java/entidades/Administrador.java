/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Izaquiel
 */
@Entity
@NamedQueries({@NamedQuery(name = "logarAdmin", query = "Select a From Administrador a Where a.login= :login "
        + "and a.senha = :senha")})
public class Administrador extends Pessoa{

    private String login;
    private String senha;

    public Administrador() {
    }

    public Administrador(String login, String senha, String nome, String cpf) {
        super(nome, cpf);
        this.login = login;
        this.senha = senha;
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
    
}
