/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import entidades.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Izaquiel
 */
public class App {
    public static void main(String[] args) {
        
        EntityManager em = Persistence.createEntityManagerFactory("com.mycompany_SigPassagensPOS_war_1.0-SNAPSHOTPU").createEntityManager();
        
        Usuario usuario = new Usuario("Izaquiel", new Date(), "zef", "123");
        
        em.persist(usuario);
    }
}
