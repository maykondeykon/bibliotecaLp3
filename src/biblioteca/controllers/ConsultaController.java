
package biblioteca.controllers;

import biblioteca.models.Emprestimo;
import biblioteca.views.GuiDevolucao;
import biblioteca.views.GuiPrincipal;
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
        Emprestimo emprestimo = service.find(id);
        
        GuiDevolucao guiDevolucao = new GuiDevolucao();
        GuiPrincipal principal = new GuiPrincipal();
        principal.exibeGui(guiDevolucao);
        
    }

}
