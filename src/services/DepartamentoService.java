package services;

import biblioteca.models.Departamento;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class DepartamentoService extends AbstractService<Departamento>
{

    public Departamento hydrate(Map<String, String> dados)
    {
        Departamento departamento = new Departamento();
        departamento.setNome(dados.get("departamento"));

        return departamento;
    }

    @Override
    public void insert(Departamento departamento)
    {
        super.insert(departamento);
    }

    public List<Departamento> findAll()
    {
        Departamento dept = new Departamento();
        return super.findAll(dept);
    }

}
