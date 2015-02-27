/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Joelanio
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.nomeCidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomeCidade, other.nomeCidade)) {
            return false;
        }
        return true;
    }
    
    
}
