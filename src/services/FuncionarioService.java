package services;

import biblioteca.models.Funcionario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class FuncionarioService extends AbstractService<Funcionario>
{

    public Funcionario hydrate(Map<String, String> dados)
    {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dados.get("nome"));
        funcionario.setMatricula(dados.get("matricula"));

        DepartamentoService depServ = new DepartamentoService();
        Integer deptId = Integer.parseInt(dados.get("departamentoId"));
        funcionario.setDepartamento(depServ.find(deptId));

        return funcionario;
    }

    @Override
    public void insert(Funcionario funcionario)
    {
        super.insert(funcionario);
    }

    public List<Funcionario> findAll()
    {
        Funcionario funcionario = new Funcionario();
        return super.findAll(funcionario);
    }

    public Funcionario find(Integer id)
    {
        return em.find(Funcionario.class, id);
    }

}
