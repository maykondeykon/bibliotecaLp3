package services;

import javax.persistence.EntityManager;
import utils.JPAUtil;

/**
 *
 * @author maykon
 */
public abstract class AbstractService<T>
{

    EntityManager em = JPAUtil.getEntityManager();

    protected void insert(T object)
    {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();

    }
}
