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
        
        Autor autor = new Autor();
        autor.setNome("João");
        
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        
        Autor autor2 = em.find(Autor.class, 1);
        
        System.out.println("nome: "+ autor2.getNome());
        
        em.close();
        emf.close();
    }

}
