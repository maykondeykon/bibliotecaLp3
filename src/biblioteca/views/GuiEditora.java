package biblioteca.views;

import biblioteca.controllers.CadastroController;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class GuiEditora extends JInternalFrame
{

    private final JTextField nome;
    private final JLabel nomeLabel;
    private final JTextField endereco;
    private final JLabel enderecoLabel;
    private final JButton salvar;

    public GuiEditora()
    {
        super("Cadastrar editora", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nome = new JTextField(25);
        nome.setName("editora");
        nomeLabel = new JLabel("Editora");
        
        endereco = new JTextField(25);
        endereco.setName("endereco");
        enderecoLabel = new JLabel("Endereço");
        
        salvar = new JButton("Salvar");

        nome.setPreferredSize(new Dimension(300, 20));

        painel.add(nomeLabel);
        painel.add(nome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(enderecoLabel);
        painel.add(endereco);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertEditora(controller.getHashMap(painel));
                nome.setText(null);
                endereco.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
