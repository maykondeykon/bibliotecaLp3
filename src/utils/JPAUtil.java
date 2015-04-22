package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author maykon
 */
public class JPAUtil
{
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaLp3");
    
    public static EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
}
