package services;

import biblioteca.models.Autor;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JTextField;

/**
 *
 * @author maykon
 */
public class AutorService extends AbstractService
{
    public Autor hidrate(Map<String, String> dados)
    {
        Autor autor = new Autor();
        autor.setNome(dados.get("nome"));

        return autor;
    }

    public Autor insert(Autor autor)
    {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();

        return autor;
    }
}
