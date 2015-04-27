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
public class GuiDepartamento extends JInternalFrame
{

    private final JTextField departamento;
    private final JLabel departamentoLabel;
    private final JButton salvar;

    public GuiDepartamento()
    {
        super("Cadastrar departamento", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        departamento = new JTextField(25);
        departamento.setName("departamento");
        departamentoLabel = new JLabel("Departamento");
        salvar = new JButton("Salvar");

        departamento.setPreferredSize(new Dimension(300, 20));

        painel.add(departamentoLabel);
        painel.add(departamento);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertDepartamento(controller.getHashMap(painel));
                departamento.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
