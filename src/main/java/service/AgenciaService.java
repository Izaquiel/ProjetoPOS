/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entidades.Passagem;
import entidades.Usuario;
import entidades.Voo;
import interfaces.Agencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Izaquiel
 */
public class AgenciaService implements Agencia{

    @Override
    public boolean salvarUsuario(Usuario usuario) {
        
    }

    @Override
    public boolean venderPassagem(Voo voo, Usuario usuario) {
       
    }

    @Override
    public List<Passagem> getPassagensPorData(Date data) {
       
    }

    @Override
    public List<Voo> getVoosPorData(Date data) {
        
    }

    @Override
    public Usuario getUsuario(String login) {
       
    }
    
}
