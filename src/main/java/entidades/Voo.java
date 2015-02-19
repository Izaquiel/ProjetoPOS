/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquiel
 */
@Entity
@NamedQueries({@NamedQuery(name = "buscaVoosPorData", query = "Select v From Voo v Where v.dataVoo = :data"),
@NamedQuery(name = "buscaTodosVoos", query = "Select v From Voo v"),
@NamedQuery(name = "buscaVoosPorCidade", query = "Select v From Voo v Where v.origem.id = :idOrigem "
        + "and v.destino.id = :idDestino"),
@NamedQuery(name = "buscaVoosPorId", query = "Select v From Voo v Where v.id = :id")})
public class Voo implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "origemId")
    private Cidade origem;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "destinoId")
    private Cidade destino;

    private Double valor;
    private Integer vagas;
    
    @Temporal(TemporalType.DATE)
    private Date dataVoo;
    
    public Voo() {
    }

    public Voo(Cidade origem, Cidade destino, Double valor, int vagas, Date dataVoo) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.vagas = vagas;
        this.dataVoo = dataVoo;
    }

    public Date getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(Date dataVoo) {
        this.dataVoo = dataVoo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    } 
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.origem);
        hash = 29 * hash + Objects.hashCode(this.destino);
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
        final Voo other = (Voo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        return true;
    }
    
}
