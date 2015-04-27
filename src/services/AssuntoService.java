package services;

import biblioteca.models.Assunto;
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

}
