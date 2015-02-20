package interfaces;

import entidades.Administrador;
import entidades.Cidade;
import entidades.Passagem;
import entidades.Usuario;
import entidades.Voo;
import java.util.List;
import javax.jws.WebMethod;

/**
 *
 * @author Izaquiel
 */
public interface AgenciaInterno {
    
    @WebMethod
    public void editarUsuario(Usuario usuario);
    
    @WebMethod
    public List<Usuario> getTodosUsuarios();
    
    @WebMethod
    public void salvarVoo(Voo voo);
    
    @WebMethod
    public void editarVoo(Voo voo);
    
    @WebMethod
    public void salvarCidade(Cidade cidade);
    
    @WebMethod
    public void editarCidade(Cidade cidade);
    
    @WebMethod
    public void editarPassagem(Passagem passagem);
    
    @WebMethod
    public List<Passagem> listarPassagens();
    
    @WebMethod
    public Voo getVooPorId(long id);
    
    @WebMethod
    public Cidade getCidadePorId(long id);
    
    @WebMethod
    public void salvarAdmin(Administrador adm);
    
    @WebMethod
    public void editarAdmin(Administrador adm);
    
    @WebMethod
    public List<Administrador> listarAdmins();
    
    @WebMethod
    public Administrador getAdminPorCpf(String cpf);
}
