package services;

import biblioteca.models.Exemplar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class ExemplarService extends AbstractService<Exemplar>
{

    public Exemplar hydrate(Map<String, String> dados)
    {
        Exemplar exemplar = new Exemplar();
        exemplar.setDtaAquisicao(new Date());
        ObraService service = new ObraService();
        Integer obraId = Integer.parseInt(dados.get("obraId"));
        exemplar.setObra(service.find(obraId));

        return exemplar;
    }

    public void insert(Exemplar exemplar)
    {
        super.insert(exemplar);

    }

    public List<Exemplar> findAll()
    {
        Exemplar exemplar = new Exemplar();
        return super.findAll(exemplar);
    }

    public Exemplar find(Integer id)
    {
        return em.find(Exemplar.class, id);
    }

}
