package teste;

import biblioteca.models.Autor;
import biblioteca.models.Departamento;
import java.util.List;
import javax.persistence.EntityManager;
import services.DepartamentoService;
import utils.JPAUtil;

/**
 *
 * @author maykon
 */
public class Teste
{
    public static void main(String[] args)
    {
        findAllDept();
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

}
