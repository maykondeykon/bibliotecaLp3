package teste;

import biblioteca.models.Autor;
import biblioteca.models.Departamento;
import biblioteca.models.Exemplar;
import java.util.List;
import javax.persistence.EntityManager;
import services.DepartamentoService;
import services.ExemplarService;
import utils.JPAUtil;

/**
 *
 * @author maykon
 */
public class Teste
{
    public static void main(String[] args)
    {
//        findAllDept();
        testeExemplar();
    }

    static void findAllDept()
    {
        DepartamentoService service = new DepartamentoService();
        List<Departamento> deptos = service.findAll();

        for (Departamento dept : deptos) {
            System.out.println(dept.getNome());
        }
    }

    static void testeJPA()
    {
        EntityManager em = JPAUtil.getEntityManager();

//        Autor autor2 = em.find(Autor.class, 1);
//        System.out.println("nome: "+ autor2.getNome());
//        List<Autor> autores = null;
//        autores = em.createNamedQuery("Autor.findAll").getResultList();
        Autor autor = (Autor) em.createNamedQuery("Autor.findByName").setParameter("nome", "J%").getSingleResult();

//        for(Autor autor : autores){
//            System.out.println(autor.getNome());
//        }
        System.out.println(autor.getNome());
    }
    
    static void testeExemplar()
    {
        ExemplarService ExemplarServ = new ExemplarService();
        Exemplar exemplar = ExemplarServ.find(1);
        exemplar.setEmprestado(2);
        ExemplarServ.insert(exemplar);
//        List<Exemplar> exemplares = ExemplarServ.findDisponiveis();
//        
//        for(Exemplar exemplar : exemplares){
//            System.out.println("exemplar = "+ exemplar.getId());
//        }
        
        
    }

}
