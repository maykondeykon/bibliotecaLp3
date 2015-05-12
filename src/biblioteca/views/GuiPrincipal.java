package biblioteca.views;

import biblioteca.models.Emprestimo;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import services.EmprestimoService;

/**
 *
 * @author maykon
 */
public class GuiPrincipal extends AbstractGui
{

    public GuiPrincipal() throws HeadlessException
    {
        this.setTitle("BiblioTech");
        this.setSize(800, 600);
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel = new JDesktopPane();
        painel.setBackground(Color.LIGHT_GRAY);
        setContentPane(painel);
        setJMenuBar(menuBar());

        this.setVisible(true);
    }
    
    public void exibeGui(JInternalFrame gui)
    {
        super.exibeGui(gui);
    }

    private JMenuBar menuBar()
    {
        JMenuBar barra = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastros");
        JMenu menuConsulta = new JMenu("Consultas");
        barra.add(menuCadastro);
        barra.add(menuConsulta);

        JMenuItem cadAutor = new JMenuItem("Autor");
        cadAutor.setActionCommand("novoAutor");
        cadAutor.addActionListener(this);

        JMenuItem cadAssunto = new JMenuItem("Assunto");
        cadAssunto.setActionCommand("novoAssunto");
        cadAssunto.addActionListener(this);

        JMenuItem cadDepartamento = new JMenuItem("Departamento");
        cadDepartamento.setActionCommand("novoDepartamento");
        cadDepartamento.addActionListener(this);
        
        JMenuItem cadEditora = new JMenuItem("Editora");
        cadEditora.setActionCommand("novaEditora");
        cadEditora.addActionListener(this);
        
        JMenuItem cadFuncionario = new JMenuItem("Funcionario");
        cadFuncionario.setActionCommand("novoFuncionario");
        cadFuncionario.addActionListener(this);
        
        JMenuItem cadUsuario = new JMenuItem("Usuário");
        cadUsuario.setActionCommand("novoUsuario");
        cadUsuario.addActionListener(this);
        
        JMenuItem cadObraTipo = new JMenuItem("Tipo de obra");
        cadObraTipo.setActionCommand("novoObraTipo");
        cadObraTipo.addActionListener(this);
        
        JMenuItem cadObra = new JMenuItem("Obra");
        cadObra.setActionCommand("novaObra");
        cadObra.addActionListener(this);
        
        JMenuItem cadExemplar = new JMenuItem("Exemplar");
        cadExemplar.setActionCommand("novoExemplar");
        cadExemplar.addActionListener(this);
        
        JMenuItem cadEmprestimo = new JMenuItem("Empréstimo");
        cadEmprestimo.setActionCommand("novoEmprestimo");
        cadEmprestimo.addActionListener(this);
        
        menuCadastro.add(cadAutor);
        menuCadastro.add(cadAssunto);
        menuCadastro.add(cadDepartamento);
        menuCadastro.add(cadEditora);
        menuCadastro.add(cadFuncionario);
        menuCadastro.add(cadUsuario);
        menuCadastro.add(cadObraTipo);
        menuCadastro.add(cadObra);
        menuCadastro.add(cadExemplar);
        menuCadastro.add(cadEmprestimo);
        
//        ---Consultas---
        
        JMenuItem consEmprestimo = new JMenuItem("Empréstimos");
        consEmprestimo.setActionCommand("consEmprestimo");
        consEmprestimo.addActionListener(this);
        
        menuConsulta.add(consEmprestimo);

        return barra;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case "novoAutor":
                guiCadAutor();
                break;
            case "novoAssunto":
                guiCadAssunto();
                break;
            case "novoDepartamento":
                guiCadDepartamento();
                break;
            case "novaEditora":
                guiCadEditora();
                break;
            case "novoFuncionario":
                guiCadFuncionario();
                break;
            case "novoUsuario":
                guiCadUsuario();
                break;
            case "novoObraTipo":
                guiCadObraTipo();
                break;
            case "novaObra":
                guiCadObra();
                break;
            case "novoExemplar":
                guiCadExemplar();
                break;
            case "novoEmprestimo":
                guiCadEmprestimo();
                break;
            case "consEmprestimo":
                guiConsEmprestimo();
                break;
        }
    }

    private void guiCadAutor()
    {
        GuiAutor guiAutor = new GuiAutor();
        exibeGui(guiAutor);
    }

    private void guiCadAssunto()
    {
        GuiAssunto guiAssunto = new GuiAssunto();
        exibeGui(guiAssunto);
    }

    private void guiCadDepartamento()
    {
        GuiDepartamento guiDepartamento = new GuiDepartamento();
        exibeGui(guiDepartamento);
    }
    
    private void guiCadEditora()
    {
        GuiEditora guiEditora = new GuiEditora();
        exibeGui(guiEditora);
    }
    
    private void guiCadFuncionario()
    {
        GuiFuncionario guiFuncionario = new GuiFuncionario();
        exibeGui(guiFuncionario);
    }
    
    private void guiCadUsuario()
    {
        GuiUsuario guiUsuario = new GuiUsuario();
        exibeGui(guiUsuario);
    }
    
    private void guiCadObraTipo()
    {
        GuiObraTipo guiObraTipo = new GuiObraTipo();
        exibeGui(guiObraTipo);
    }
    
    private void guiCadObra()
    {
        GuiObra guiObra = new GuiObra();
        exibeGui(guiObra);
    }
    
    private void guiCadExemplar()
    {
        GuiExemplar guiExemplar = new GuiExemplar();
        exibeGui(guiExemplar);
    }
    
    private void guiCadEmprestimo()
    {
        GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
        exibeGui(guiEmprestimo);
    }
    
    //        ---Consultas---
    
    private void guiConsEmprestimo()
    {
        GuiConsultaEmprestimo guiEmprestimo = new GuiConsultaEmprestimo();
        
        EmprestimoService emprestServ = new EmprestimoService();
        List <Emprestimo> emprestimos = emprestServ.findEmprestados();
        
        exibeGui(guiEmprestimo.listaEmprestimos(emprestimos));
    }

    public static void main(String[] args)
    {
        new GuiPrincipal();
    }

}
