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
public class GuiAssunto extends JInternalFrame
{

    private final JTextField assunto;
    private final JLabel assuntoLabel;
    private final JButton salvar;

    public GuiAssunto()
    {
        super("Cadastrar assunto", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        assunto = new JTextField(25);
        assunto.setName("assunto");
        assuntoLabel = new JLabel("Assunto");
        salvar = new JButton("Salvar");

        assunto.setPreferredSize(new Dimension(300, 20));

        painel.add(assuntoLabel);
        painel.add(assunto);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertAssunto(controller.getHashMap(painel));
                assunto.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
