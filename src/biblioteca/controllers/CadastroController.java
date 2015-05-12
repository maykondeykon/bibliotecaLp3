package biblioteca.controllers;

import biblioteca.models.Assunto;
import biblioteca.models.Autor;
import biblioteca.models.Departamento;
import biblioteca.models.Editora;
import biblioteca.models.Emprestimo;
import biblioteca.models.Exemplar;
import biblioteca.models.Funcionario;
import biblioteca.models.Obra;
import biblioteca.models.ObraTipo;
import biblioteca.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import services.AssuntoService;
import services.AutorService;
import services.DepartamentoService;
import services.EditoraService;
import services.EmprestimoService;
import services.ExemplarService;
import services.FuncionarioService;
import services.ObraService;
import services.ObraTipoService;
import services.UsuarioService;

/**
 *
 * @author maykon
 */
public class CadastroController extends AbstractController
{

    public void insertAutor(Map<String, String> dados)
    {
        if (isValid(dados)) {
            AutorService service = new AutorService();
            Autor autor = service.hydrate(dados);
            service.insert(autor);
        }
    }

    public void insertAssunto(Map<String, String> dados)
    {
        if (isValid(dados)) {
            AssuntoService service = new AssuntoService();
            Assunto assunto = service.hydrate(dados);
            service.insert(assunto);
        }
    }

    public void insertDepartamento(Map<String, String> dados)
    {
        if (isValid(dados)) {
            DepartamentoService service = new DepartamentoService();
            Departamento departamento = service.hydrate(dados);
            service.insert(departamento);
        }
    }

    public void insertEditora(Map<String, String> dados)
    {
        if (isValid(dados)) {
            EditoraService service = new EditoraService();
            Editora editora = service.hydrate(dados);
            service.insert(editora);
        }
    }

    public void insertFuncionario(Map<String, String> dados)
    {
        if (isValid(dados)) {
            FuncionarioService service = new FuncionarioService();
            Funcionario funcionario = service.hydrate(dados);
            service.insert(funcionario);
        }
    }

    public void insertUsuario(Map<String, String> dados)
    {
        if (isValid(dados)) {
            UsuarioService service = new UsuarioService();
            Usuario usuario = service.hydrate(dados);
            service.insert(usuario);
        }
    }

    public void insertObraTipo(Map<String, String> dados)
    {
        if (isValid(dados)) {
            ObraTipoService service = new ObraTipoService();
            ObraTipo obraTipo = service.hydrate(dados);
            service.insert(obraTipo);
        }
    }

    public void insertObra(Map<String, String> dados)
    {
        if (isValid(dados)) {
            ObraService service = new ObraService();
            Obra obra = service.hydrate(dados);

            AutorService autorServ = new AutorService();
            Integer autorId = Integer.parseInt(dados.get("autorId"));
            Autor autor = autorServ.find(autorId);

            AssuntoService assuntoServ = new AssuntoService();
            Integer assuntoId = Integer.parseInt(dados.get("assuntoId"));
            Assunto assunto = assuntoServ.find(assuntoId);

            service.insert(obra, autor, assunto);
        }
    }

    public void insertExemplar(Map<String, String> dados)
    {
        if (isValid(dados)) {
            Integer qtd = Integer.parseInt(dados.get("qtd"));

            for (int i = 0; i < qtd; i++) {
                ExemplarService service = new ExemplarService();
                Exemplar exemplar = service.hydrate(dados);
                service.insert(exemplar);
            }

        }
    }

    public void insertEmprestimo(Map<String, String> dados)
    {
        if (isValid(dados)) {
            EmprestimoService service = new EmprestimoService();
            Emprestimo emprestimo = service.hydrate(dados);
            service.insert(emprestimo);
        }
    }

}
