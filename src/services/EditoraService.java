package services;

import biblioteca.models.Editora;
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

}
