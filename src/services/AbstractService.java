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
 */
public abstract class AbstractService<T extends Serializable>
{
    private Class<T> clazz;

    EntityManager em = JPAUtil.getEntityManager();

    protected void insert(T object)
    {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();

    }

    protected List<T> findAll()
    {
        return em.createQuery("FROM " + clazz.getName()).getResultList();
    }
}
