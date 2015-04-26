package biblioteca.controllers;

import biblioteca.models.Autor;
import biblioteca.views.GuiAutor;
import biblioteca.views.GuiPrincipal;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import services.AutorService;
import utils.JPAUtil;

/**
 *
 * @author maykon
 */
public class CadastroController extends AbstractController
{
    
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
    
//    static void guiPrincipal()
//    {
//        guiPrincipal();
//    }
    
    public void insertAutor(Map<String,String> dados)
    {
//        for(int i = 0; i < dados.size();i++){
////            System.out.println(dados.keySet()+"-"+ dados.values());
//            System.out.println(dados.get("nome"));
//        }
        
        if(isValid(dados)){
            AutorService service = new AutorService();
            Autor autor = service.hidrate(dados);
            service.insert(autor);
        }
        
        
        
    }

}
