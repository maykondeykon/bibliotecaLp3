
package biblioteca.controllers;

import services.EmprestimoService;

/**
 *
 * @author maykon
 */
public class ConsultaController extends AbstractController
{

    public void devolveEmprestimo(Integer id)
    {
        EmprestimoService service = new EmprestimoService();
        service.devolver(id);
        
    }

}
