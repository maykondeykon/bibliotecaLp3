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
public class GuiObraTipo extends JInternalFrame
{

    private final JTextField nome;
    private final JLabel nomeLabel;
    private final JButton salvar;

    public GuiObraTipo()
    {
        super("Cadastrar tipo de obra", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nome = new JTextField(25);
        nome.setName("nome");
        nomeLabel = new JLabel("Nome");
        salvar = new JButton("Salvar");

        nome.setPreferredSize(new Dimension(300, 20));

        painel.add(nomeLabel);
        painel.add(nome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertObraTipo(controller.getHashMap(painel));
                nome.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
