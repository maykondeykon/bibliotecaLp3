package services;

import biblioteca.models.Emprestimo;
import biblioteca.models.Exemplar;
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
        emprestimo.setExemplar(ExemplarServ.find(exemplarId));

        UsuarioService UsuarioServ = new UsuarioService();
        Integer usuarioId = Integer.parseInt(dados.get("usuarioId"));
        emprestimo.setUsuario(UsuarioServ.find(usuarioId));

        FuncionarioService funcServ = new FuncionarioService();
        Integer funcId = 1;//Setado para o 1º
        emprestimo.setFuncEmprestimo(funcServ.find(funcId));

        return emprestimo;
    }

    public void insert(Emprestimo emprestimo)
    {
        Exemplar exemplar = emprestimo.getExemplar();
        exemplar.setEmprestado(1);//seta como emprestado

        em.getTransaction().begin();
        em.persist(emprestimo);
        em.merge(exemplar);
        em.getTransaction().commit();
        em.close();

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
    
    public List<Emprestimo> findEmprestados()
    {
        String sql = "SELECT e FROM Emprestimo e WHERE e.dtaDevolucao IS NULL";
        return em.createQuery(sql).getResultList();
    }

    public void devolver(Integer id)
    {
        Emprestimo emprestimo = this.find(id);
        emprestimo.setDtaDevolucao(new Date());

        FuncionarioService funcServ = new FuncionarioService();
        Integer funcId = 1;//Setado para o 1º
        emprestimo.setFuncDevolucao(funcServ.find(funcId));

        Exemplar exemplar = emprestimo.getExemplar();
        exemplar.setEmprestado(0);

        em.getTransaction().begin();
        em.persist(emprestimo);
        em.merge(exemplar);
        em.getTransaction().commit();
        em.close();
    }

}
