package services;

import javax.persistence.EntityManager;
import utils.JPAUtil;

/**
 *
 * @author maykon
 */
public abstract class AbstractService
{
    EntityManager em = JPAUtil.getEntityManager();
}
