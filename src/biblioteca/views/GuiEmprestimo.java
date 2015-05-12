package biblioteca.views;

import biblioteca.controllers.CadastroController;
import biblioteca.models.Exemplar;
import biblioteca.models.Usuario;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import services.ExemplarService;
import services.UsuarioService;

/**
 *
 * @author maykon
 */
public class GuiEmprestimo extends JInternalFrame
{

    private final JComboBox exemplar;
    private final JTextField exemplarId;
    private final JLabel exemplarLabel;
    private final JComboBox usuario;
    private final JTextField usuarioId;
    private final JLabel usuarioLabel;
//    private final JTextField dtaEmprestimo;
//    private final JLabel dtaEmpLabel;
    private final JButton salvar;
    private final List<Exemplar> exemplares;
    private final List<Usuario> usuarios;

    public GuiEmprestimo()
    {
        super("Cadastrar empréstimo", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

//        dtaEmprestimo = new JTextField(25);
//        dtaEmprestimo.setName("dtaEmprestimo");
//        dtaEmpLabel = new JLabel("Data de aquisição");
        
        exemplar = new JComboBox();
        exemplar.setName("exemplar");
        exemplarLabel = new JLabel("Exemplar");
        
        exemplarId = new JTextField(25);
        exemplarId.setName("exemplarId");
        exemplarId.setVisible(false);
        
        usuario = new JComboBox();
        usuario.setName("usuario");
        usuarioLabel = new JLabel("Usuário");
        
        usuarioId = new JTextField(25);
        usuarioId.setName("usuarioId");
        usuarioId.setVisible(false);
        
        salvar = new JButton("Salvar");
        
        ExemplarService exemplarServ = new ExemplarService();
        exemplares = exemplarServ.findDisponiveis();

        exemplar.addItem("Selecione");
        for (Exemplar exemplarClass : exemplares) {
            exemplar.addItem(exemplarClass.getObra().getNome() + " - exemplar "+ exemplarClass.getId());
        }
        
        UsuarioService usuarioServ = new UsuarioService();
        usuarios = usuarioServ.findAll();

        usuario.addItem("Selecione");
        for (Usuario usuarioClass : usuarios) {
            usuario.addItem(usuarioClass.getNome());
        }

        exemplar.setPreferredSize(new Dimension(300, 20));

        painel.add(exemplarLabel);
        painel.add(exemplar);
        painel.add(exemplarId);
        painel.add(Box.createVerticalStrut(20));
        painel.add(usuarioLabel);
        painel.add(usuario);
        painel.add(usuarioId);
        painel.add(Box.createVerticalStrut(20));
//        painel.add(dtaEmpLabel);
//        painel.add(dtaEmprestimo);
//        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);
        
        exemplar.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                exemplarId.setText(exemplares.get(exemplar.getSelectedIndex() -1).getId().toString());//copiar para outras gui's
            }
        });
        
        usuario.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                usuarioId.setText(usuario.getSelectedIndex() + "");
            }
        });

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertEmprestimo(controller.getHashMap(painel));
//                dtaEmprestimo.setText(null);
                exemplar.removeItem(exemplar.getSelectedItem());
                exemplar.setSelectedIndex(0);
                exemplarId.setText(null);
                usuario.setSelectedIndex(0);
                usuarioId.setText(null);
//                exemplar.updateUI();
            }
        });

        setContentPane(painel);
        pack();
    }

}
