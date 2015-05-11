package services;

import biblioteca.models.Emprestimo;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class EmprestimoService extends AbstractService<Emprestimo>
{

    public Emprestimo hydrate(Map<String, String> dados)
    {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDtaEmprestimo(new Date());
        
        ExemplarService ExemplarServ = new ExemplarService();
        Integer exemplarId = Integer.parseInt(dados.get("exemplarId"));
//        emprestimo.setExemplar(service.find(exemplarId));
        
        UsuarioService UsuarioServ = new UsuarioService();
        Integer usuarioId = Integer.parseInt(dados.get("usuarioId"));
        emprestimo.setUsuario(UsuarioServ.find(usuarioId));
//        
        FuncionarioService funcServ = new FuncionarioService();
        Integer funcId = 1;//Setado para o 1º
        emprestimo.setFuncEmprestimo(funcServ.find(funcId));

        return emprestimo;
    }

    public void insert(Emprestimo emprestimo)
    {
        super.insert(emprestimo);

    }

    public List<Emprestimo> findAll()
    {
        Emprestimo emprestimo = new Emprestimo();
        return super.findAll(emprestimo);
    }

    public Emprestimo find(Integer id)
    {
        return em.find(Emprestimo.class, id);
    }

}
