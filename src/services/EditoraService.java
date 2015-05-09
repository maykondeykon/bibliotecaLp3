package services;

import biblioteca.models.Editora;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class EditoraService extends AbstractService<Editora>
{
    public Editora hydrate(Map<String, String> dados)
    {
        Editora editora = new Editora();
        editora.setNome(dados.get("editora"));
        editora.setEndereco(dados.get("endereco"));

        return editora;
    }

    @Override
    public void insert(Editora editora)
    {
        super.insert(editora);
    }

    public List<Editora> findAll()
    {
        Editora editora = new Editora();
        return super.findAll(editora);
    }

    public Editora find(Integer id)
    {
        return em.find(Editora.class, id);
    }

}
