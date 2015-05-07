package teste;

import biblioteca.models.Departamento;
import java.util.List;
import services.DepartamentoService;

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
        
        for(Departamento dept : deptos){
            System.out.println(dept.getNome());
        }
    }
    
    
}
