/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entidades.Cidade;
import entidades.Passagem;
import entidades.Usuario;
import entidades.Voo;
import interfaces.AgenciaInterno;
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
@WebService(name = "AgenciaInterno")
public class AgenciaInternaService implements AgenciaInterno{
    @EJB
    Dao<Usuario> daoUsuario;
    @EJB
    Dao<Cidade> daoCidade;
    @EJB
    Dao<Voo> daoVoo;
    @EJB
    Dao<Passagem> daoPassagem;
    
    @Override
    public void editarUsuario(Usuario usuario) {
        daoUsuario.atualizar(usuario);
    }

    @Override
    public List<Usuario> getTodosUsuarios() {
        return daoUsuario.buscarTodos("listarTodosUsuarios");
    }

    @Override
    public void salvarVoo(Voo voo) {
        daoVoo.salvar(voo);
    }

    @Override
    public void editarVoo(Voo voo) {
        daoVoo.atualizar(voo);
    }

    @Override
    public void salvarCidade(Cidade cidade) {
        daoCidade.salvar(cidade);
    }

    @Override
    public void editarCidade(Cidade cidade) {
        daoCidade.atualizar(cidade);
    }

    @Override
    public void editarPassagem(Passagem passagem) {
        daoPassagem.atualizar(passagem);
    }

    @Override
    public List<Passagem> listarPassagens() {
        return daoPassagem.buscarTodos("listaTodasPassagens");
    }

    @Override
    public Voo getVooPorId(long id) {
        Map<String, Long> map = new HashMap<>();
        map.put("id", id);
        return daoVoo.buscar("buscaVoosPorId", map);
    }

    @Override
    public Cidade getCidadePorId(long id) {
        Map<String, Long> map = new HashMap<>();
        map.put("id", id);
        return daoCidade.buscar("buscaCidadePorId", map);
    }
    
}
