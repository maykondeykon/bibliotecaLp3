package services;

import biblioteca.models.Autor;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class AutorService extends AbstractService<Autor>
{
    public Autor hydrate(Map<String, String> dados)
    {
        Autor autor = new Autor();
        autor.setNome(dados.get("nome"));

        return autor;
    }

    @Override
    public void insert(Autor autor)
    {
        super.insert(autor);
    }

    public List<Autor> findAll()
    {
        Autor autor = new Autor();
        return super.findAll(autor);
    }

    public Autor find(Integer id)
    {
        return em.find(Autor.class, id);
    }

}
