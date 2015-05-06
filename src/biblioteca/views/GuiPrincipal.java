package biblioteca.views;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

        menuCadastro.add(cadAutor);
        menuCadastro.add(cadAssunto);
        menuCadastro.add(cadDepartamento);
        menuCadastro.add(cadEditora);
        menuCadastro.add(cadFuncionario);

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
            case "novaFuncionario":
                guiCadFuncionario();
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

    public static void main(String[] args)
    {
        new GuiPrincipal();
    }

}
