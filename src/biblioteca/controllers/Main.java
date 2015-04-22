package biblioteca.controllers;

import biblioteca.models.Autor;
import biblioteca.views.GuiAutor;
import biblioteca.views.GuiPrincipal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import utils.JPAUtil;

/**
 *
 * @author maykon
 */
public class Main 
{

    public static void main(String[] args) 
    {
        guiPrincipal();
    }
    
    static void testeJPA()
    {
        EntityManager em = JPAUtil.getEntityManager();
        
//        Autor autor2 = em.find(Autor.class, 1);
//        System.out.println("nome: "+ autor2.getNome());
        
//        List<Autor> autores = null;
//        autores = em.createNamedQuery("Autor.findAll").getResultList();
        Autor autor = (Autor) em.createNamedQuery("Autor.findByName").setParameter("nome", "J%").getSingleResult();
        
//        for(Autor autor : autores){
//            System.out.println(autor.getNome());
//        }
        
        System.out.println(autor.getNome());
    }
    
    static void guiPrincipal()
    {
        JFrame guiPrincipal = new GuiPrincipal();
    }

}
