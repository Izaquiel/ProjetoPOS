/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import entidades.Administrador;
import entidades.Cidade;
import entidades.Usuario;
import entidades.Voo;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;

/**
 *
 * @author Izaquiel
 */
public interface Agencia {
    
    @WebMethod
    public boolean salvarUsuario(Usuario usuario);
    
    @WebMethod
    public boolean venderPassagem(long idVoo, Usuario usuario);
    
    @WebMethod
    public List<Voo> getVoosPorData(Date data);
    
    @WebMethod
    public Usuario getUsuario(String cpf);
    
    @WebMethod
    public Administrador getAdministrador(String login, String senha);
    
    @WebMethod
    public List<Voo> getTodosVoos();
    
    @WebMethod
    public List<Cidade> getCidades();
    
    @WebMethod
    public Voo getVoo(long cidadeOrigem, long cidadeDestino);
    
    @WebMethod
    public Voo getVooPorId(long id);
}
