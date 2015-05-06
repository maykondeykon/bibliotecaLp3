package biblioteca.views;

import biblioteca.controllers.CadastroController;
import biblioteca.models.Departamento;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import services.DepartamentoService;

/**
 *
 * @author maykon
 */
public class GuiFuncionario extends JInternalFrame
{

    private final JTextField nome;
    private final JLabel nomeLabel;
    private final JTextField matricula;
    private final JLabel matriculaLabel;
    private final JComboBox departamento;
    private final JLabel depLabel;
    private final JButton salvar;

    public GuiFuncionario()
    {
        super("Cadastrar funcionário", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nome = new JTextField(25);
        nome.setName("editora");
        nomeLabel = new JLabel("Editora");
        
        matricula = new JTextField(25);
        matricula.setName("matricula");
        matriculaLabel = new JLabel("Matrícula");
        
        departamento = new JComboBox();
        departamento.setName("departamento");
        depLabel = new JLabel("Departamento");
        
        List<Departamento> deptos = null;
        DepartamentoService depServ = new DepartamentoService();
        
        
        salvar = new JButton("Salvar");

        nome.setPreferredSize(new Dimension(300, 20));

        painel.add(nomeLabel);
        painel.add(nome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(matriculaLabel);
        painel.add(matricula);
        painel.add(Box.createVerticalStrut(20));
        painel.add(depLabel);
        painel.add(departamento);
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
                matricula.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
