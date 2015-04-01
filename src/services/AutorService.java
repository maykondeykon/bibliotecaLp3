package services;

import biblioteca.models.Autor;
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

}
