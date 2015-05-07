package biblioteca.views;

import biblioteca.controllers.CadastroController;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maykon
 */
public class GuiUsuario extends JInternalFrame
{

    private final JTextField nome;
    private final JLabel nomeLabel;
    private final JTextField endereco;
    private final JLabel enderecoLabel;
    private final JTextField telefone;
    private final JLabel telefoneLabel;
    private final JButton salvar;

    public GuiUsuario() throws HeadlessException
    {
        super("Cadastrar usuário", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nome = new JTextField(25);
        nome.setName("nome");
        nomeLabel = new JLabel("Nome");
        
        endereco = new JTextField(25);
        endereco.setName("endereco");
        enderecoLabel = new JLabel("Endereço");
        
        telefone = new JTextField(25);
        telefone.setName("telefone");
        telefoneLabel = new JLabel("Telefone");
        
        salvar = new JButton("Salvar");

        nome.setPreferredSize(new Dimension(300, 20));

        painel.add(nomeLabel);
        painel.add(nome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(enderecoLabel);
        painel.add(endereco);
        painel.add(Box.createVerticalStrut(20));
        painel.add(telefoneLabel);
        painel.add(telefone);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertUsuario(controller.getHashMap(painel));
                nome.setText(null);
                endereco.setText(null);
                telefone.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

    private void msg(String msg)
    {
        JOptionPane.showMessageDialog(
                null, msg, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

}
