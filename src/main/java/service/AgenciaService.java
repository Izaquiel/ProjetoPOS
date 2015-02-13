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
    public boolean venderPassagem(long idVoo, Usuario usuario) {
        Map<String, Long> map = new HashMap<>();
        map.put("id", idVoo);
        Voo voo = daoVoo.buscar("buscaVoosPorId", map);
        if (voo != null) {
            Passagem passagem = new Passagem(usuario, voo);
            daoPassagem.salvar(passagem);
            return true;
        }else
            return false;
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
    public List<Voo> getTodosVoos() {
        return daoVoo.buscarTodos("buscaTodosVoos");
    }

}
