package services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import utils.JPAUtil;

/**
 *
 * @author maykon
 * @param <T>
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

    protected List<T> findAll(T object)
    {
        return em.createQuery("SELECT a FROM " + object.getClass().getName() +" a").getResultList();
    }
}
