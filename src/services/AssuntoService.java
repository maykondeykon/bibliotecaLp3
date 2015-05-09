package services;

import biblioteca.models.Assunto;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class AssuntoService extends AbstractService<Assunto>
{

    public Assunto hydrate(Map<String, String> dados)
    {
        Assunto assunto = new Assunto();
        assunto.setDescricao(dados.get("assunto"));

        return assunto;
    }

    @Override
    public void insert(Assunto assunto)
    {
        super.insert(assunto);
    }

    public List<Assunto> findAll()
    {
        Assunto assunto = new Assunto();
        return super.findAll(assunto);
    }

    public Assunto find(Integer id)
    {
        return em.find(Assunto.class, id);
    }

}
