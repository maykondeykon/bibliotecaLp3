package services;

import biblioteca.models.ObraTipo;
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

}
