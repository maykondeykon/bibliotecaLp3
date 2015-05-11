package biblioteca.views;

import biblioteca.controllers.CadastroController;
import biblioteca.models.Obra;
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
import services.ObraService;

/**
 *
 * @author maykon
 */
public class GuiExemplar extends JInternalFrame
{

    private final JComboBox obra;
    private final JTextField obraId;
    private final JLabel obraLabel;
//    private final JTextField dtaAquisicao;
//    private final JLabel dtaLabel;
    private final JTextField qtd;
    private final JLabel qtdLabel;
    private final JButton salvar;
    private List<Obra> obras;

    public GuiExemplar()
    {
        super("Cadastrar exemplares", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

//        dtaAquisicao = new JTextField(25);
//        dtaAquisicao.setName("dtaAquisicao");
//        dtaLabel = new JLabel("Data de aquisição");
        
        qtd = new JTextField(25);
        qtd.setName("qtd");
        qtdLabel = new JLabel("Quantidade");
        
        obra = new JComboBox();
        obra.setName("obra");
        obraLabel = new JLabel("Obra");
        
        obraId = new JTextField(25);
        obraId.setName("obraId");
        obraId.setVisible(false);
        
        salvar = new JButton("Salvar");
        
        ObraService obraServ = new ObraService();
        obras = obraServ.findAll();

        obra.addItem("Selecione");
        for (Obra obraClass : obras) {
            obra.addItem(obraClass.getNome());
        }

        obra.setPreferredSize(new Dimension(300, 20));

        painel.add(obraLabel);
        painel.add(obra);
        painel.add(obraId);
        painel.add(Box.createVerticalStrut(20));
        painel.add(qtdLabel);
        painel.add(qtd);
        painel.add(Box.createVerticalStrut(20));
//        painel.add(dtaLabel);
//        painel.add(dtaAquisicao);
//        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);
        
        obra.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                obraId.setText(obra.getSelectedIndex() + "");
            }
        });

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertExemplar(controller.getHashMap(painel));
                qtd.setText(null);
//                dtaAquisicao.setText(null);
                obra.setSelectedIndex(0);
                obraId.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
