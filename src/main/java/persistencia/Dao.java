package persistencia;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Izaquiel Cruz
 * @param <T>
 */
@Stateless
public class Dao<T> {
    
    @PersistenceContext(unitName = "com.mycompany_SigPassagensPOS_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public void salvar(Object novo)throws EJBException{
        em.persist(novo);
    }
    
    public void atualizar(Object o) {
        em.merge(o);
    }
    
    public void remover(Object o) {
        em.remove(em.merge(o));
    }
    
    public T buscar(String namedQuery, Map paramentros)throws NoResultException{
        
        Query consulta = em.createNamedQuery(namedQuery);
        
        Set<String> chaves = paramentros.keySet();
        
        for (String chave : chaves) {
            consulta.setParameter(chave, paramentros.get(chave));
        }
    
        return  (T) consulta.getSingleResult();
    
    }    
    
    public List<T> buscarTodos(String namedQuery) {
        
        Query consulta = em.createNamedQuery(namedQuery);
        
        return consulta.getResultList();
        
    }    
    
    public List<T> buscarTodosPorData(String namedQuery, Date data) {
        
        Query consulta = em.createNamedQuery(namedQuery);
        
        consulta.setParameter("data", data, TemporalType.DATE);
        
        return consulta.getResultList();
        
    }    
    
    public void setStatus(String namedQuery, Map paramentros) {
        
        Query consulta = em.createNamedQuery(namedQuery);
        Set<String> chaves = paramentros.keySet();
        
        for (String chave : chaves) {
            consulta.setParameter(chave, paramentros.get(chave));
        }
        
        consulta.executeUpdate();
        
    }
    
}
