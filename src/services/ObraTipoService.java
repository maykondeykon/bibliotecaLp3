package services;

import biblioteca.models.ObraTipo;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class ObraTipoService extends AbstractService<ObraTipo>
{
    public ObraTipo hydrate(Map<String, String> dados)
    {
        ObraTipo obraTipo = new ObraTipo();
        obraTipo.setNome(dados.get("nome"));

        return obraTipo;
    }

    @Override
    public void insert(ObraTipo obraTipo)
    {
        super.insert(obraTipo);
    }

    public List<ObraTipo> findAll()
    {
        ObraTipo obraTipo = new ObraTipo();
        return super.findAll(obraTipo);
    }

    public ObraTipo find(Integer id)
    {
        return em.find(ObraTipo.class, id);
    }

}
