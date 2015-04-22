package biblioteca.views;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author maykon
 */
public class GuiPrincipal extends JFrame implements ActionListener
{
    JDesktopPane painel;

    public GuiPrincipal() throws HeadlessException
    {
        super("BiblioTech");
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
        
        menuCadastro.add(cadAutor);

        return barra;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ("novoAutor".equals(e.getActionCommand())) {
            guiCadAutor();
        }
    }

    private void guiCadAutor()
    {
        GuiAutor guiAutor = new GuiAutor();
        guiAutor.setVisible(true);
        painel.add(guiAutor);
    }

}
