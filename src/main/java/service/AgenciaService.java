package service;

import entidades.Administrador;
import entidades.Cidade;
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
    @EJB
    Dao<Administrador> daoAdm;
    @EJB
    Dao<Cidade> daoCidade;

    @Override
    public boolean salvarUsuario(Usuario usuario) {
        daoUsuario.salvar(usuario);
        return true;
    }

    @Override
    public boolean venderPassagem(long idVoo, Usuario usuario) {
        Map<String, Long> map = new HashMap<>();
        map.put("id", idVoo);
        Voo voo = daoVoo.buscar("buscaVoosPorId", map);
        if (voo != null) {
            Passagem passagem = new Passagem(usuario, voo);
            daoPassagem.salvar(passagem);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Voo> getVoosPorData(Date data) {
        System.out.println(data.toString());
        return daoVoo.buscarTodosPorData("buscaVoosPorData", data);
    }

    @Override
    public Usuario getUsuario(String cpf) {
        Map<String, String> map = new HashMap<>();
        map.put("cpf", cpf);
        return daoUsuario.buscar("buscarUsuarioPorCpf", map);
    }

    @Override
    public List<Voo> getTodosVoos() {
        return daoVoo.buscarTodos("buscaTodosVoos");
    }

    @Override
    public Administrador getAdministrador(String login, String senha) {
        Map<String, String> map = new HashMap<>();
        map.put("login", login);
        map.put("senha", senha);
        return daoAdm.buscar("logarAdmin", map);
    }

    @Override
    public List<Cidade> getCidades() {
        return daoCidade.buscarTodos("listaTodasCidades");
    }

    @Override
    public Voo getVoo(long cidadeOrigem, long cidadeDestino) {
        Map<String, Long> map = new HashMap<>();
        map.put("idOrigem", cidadeOrigem);
        map.put("idDestino", cidadeDestino);
        return daoVoo.buscar("buscaVoosPorCidade", map);
    }

}
