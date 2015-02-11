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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.jws.WebService;
import persistencia.Dao;

/**
 *
 * @author Izaquiel
 */
@WebService(serviceName = "Passagens")
public class AgenciaService implements Agencia {

    @EJB
    Dao<Usuario> daoUsuario;
    @EJB
    Dao<Passagem> daoPassagem;
    @EJB
    Dao<Voo> daoVoo;

    @Override
    public boolean salvarUsuario(Usuario usuario) {
        daoUsuario.salvar(usuario);
        return true;
    }

    @Override
    public boolean venderPassagem(Voo voo, Usuario usuario) {
        Passagem passagem = new Passagem(usuario, voo);
        daoPassagem.salvar(passagem);
        return true;
    }

    @Override
    public List<Voo> getVoosPorData(Date data) {
        System.out.println(data.toString());
        return daoVoo.buscarTodosPorData("buscaVoosPorData", data);
    }

    @Override
    public Usuario getUsuario(String login) {
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        return daoUsuario.buscar("buscarUsuarioPorLogin", map);
    }

    @Override
    public String getNomeUsuario(String login) {
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        Usuario user = daoUsuario.buscar("buscarUsuarioPorLogin", map);
        return user.getNome();
    }

}
