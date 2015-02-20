/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquiel
 */
@Entity
@NamedQueries({@NamedQuery(name = "listarTodosUsuarios", query = "Select u From Usuario u"),
@NamedQuery(name = "buscarUsuarioPorCpf", query = "Select u From Usuario u Where u.cpf = :cpf")})
public class Usuario extends Pessoa{
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    public Usuario() {
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: "+ this.getNome() + " CPF: " + this.getCpf();
    }
    
    
    
}
