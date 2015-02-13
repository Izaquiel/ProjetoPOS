/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Izaquiel
 */
@Entity
@NamedQueries({@NamedQuery(name = "listaTodasCidades", query = "Select c From Cidade c"),
@NamedQuery(name = "buscaCidadePorId", query = "Select c From Cidade c Where c.id = :id")})
public class Cidade implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    
    private String nomeCidade;

    public Cidade() {
    }

    public Cidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    
    
}
