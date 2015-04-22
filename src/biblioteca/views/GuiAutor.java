package biblioteca.views;

import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maykon
 */
public class GuiAutor extends JInternalFrame
{
    private final JTextField nome;
    private final JLabel nomeLabel;
    private final JButton salvar;

    public GuiAutor() throws HeadlessException
    {
        super("Cadastrar autor", true, true, false, true);
        
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        nome = new JTextField(25);
        nomeLabel = new JLabel("Nome");
        salvar = new JButton("Salvar");
        
        nome.setPreferredSize(new Dimension(300, 20));
        
        painel.add(nomeLabel);
        painel.add(nome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);
        
        setContentPane(painel);
        pack();
    }

}
