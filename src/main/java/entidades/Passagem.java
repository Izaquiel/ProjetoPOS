/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Wagner Abreu
 */
@Entity
@NamedQueries({@NamedQuery(name = "listaTodasPassagens", query = "Select p From Passagem p")})
public class Passagem implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vooId")
    private Voo voo;
   

    public Passagem() {
    }

    public Passagem( Usuario usuario, Voo voo) {
        this.usuario = usuario;
        this.voo = voo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
       
}
