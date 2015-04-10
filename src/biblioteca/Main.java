package biblioteca;

import biblioteca.models.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author maykon
 */
public class Main 
{

    public static void main(String[] args) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaLp3");
        
        EntityManager em = emf.createEntityManager();
        
        Autor autor = em.find(Autor.class, 1);
        
        System.out.println("nome: "+ autor.getNome());
        
        em.close();
        emf.close();
    }

}
