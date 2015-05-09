package biblioteca.views;

import biblioteca.controllers.CadastroController;
import biblioteca.models.Assunto;
import biblioteca.models.Autor;
import biblioteca.models.Departamento;
import biblioteca.models.Editora;
import biblioteca.models.ObraTipo;
import java.awt.Color;
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
import services.AssuntoService;
import services.AutorService;
import services.DepartamentoService;
import services.EditoraService;
import services.ObraTipoService;

/**
 *
 * @author maykon
 */
public class GuiObra extends JInternalFrame
{

    private final JTextField nome;
    private final JLabel nomeLabel;
    private final JTextField codigo;
    private final JLabel codigoLabel;
    private final JTextField ano;
    private final JLabel anoLabel;
    private final JComboBox editora;
    private final JTextField editoraId;
    private final JLabel editoraLabel;
    private final JComboBox tipo;
    private final JTextField tipoId;
    private final JLabel tipoLabel;
    private final JComboBox autor;
    private final JTextField autorId;
    private final JLabel autorLabel;
    private final JComboBox assunto;
    private final JTextField assuntoId;
    private final JLabel assuntoLabel;
    private final JButton salvar;
    private List<Editora> editoras;
    private List<ObraTipo> tipos;
    private List<Autor> autores;
    private List<Assunto> assuntos;

    public GuiObra()
    {
        super("Cadastrar obra", true, true, false, true);

        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        nome = new JTextField(25);
        nome.setName("nome");
        nomeLabel = new JLabel("Nome");

        codigo = new JTextField(25);
        codigo.setName("codigo");
        codigoLabel = new JLabel("Código");

        ano = new JTextField(25);
        ano.setName("ano");
        anoLabel = new JLabel("Ano");

        editoraId = new JTextField(25);
        editoraId.setName("editoraId");
        editoraId.setVisible(false);

        editora = new JComboBox();
        editora.setName("editora");
        editoraLabel = new JLabel("Editora");

        tipoId = new JTextField(25);
        tipoId.setName("tipoId");
        tipoId.setVisible(false);

        tipo = new JComboBox();
        tipo.setName("tipo");
        tipoLabel = new JLabel("Tipo");

        autorId = new JTextField(25);
        autorId.setName("autorId");
        autorId.setVisible(false);

        autor = new JComboBox();
        autor.setName("autor");
        autorLabel = new JLabel("Autor");

        assuntoId = new JTextField(25);
        assuntoId.setName("assuntoId");
        assuntoId.setVisible(false);

        assunto = new JComboBox();
        assunto.setName("assunto");
        assuntoLabel = new JLabel("Assunto");

        EditoraService editoraServ = new EditoraService();
        editoras = editoraServ.findAll();

        editora.addItem("Selecione");
        for (Editora depto : editoras) {
            editora.addItem(depto.getNome());
        }

        ObraTipoService tipoServ = new ObraTipoService();
        tipos = tipoServ.findAll();

        tipo.addItem("Selecione");
        for (ObraTipo obraTipo : tipos) {
            tipo.addItem(obraTipo.getNome());
        }

        AutorService autorServ = new AutorService();
        autores = autorServ.findAll();

        autor.addItem("Selecione");
        for (Autor autorClass : autores) {
            autor.addItem(autorClass.getNome());
        }

        AssuntoService assuntoServ = new AssuntoService();
        assuntos = assuntoServ.findAll();

        assunto.addItem("Selecione");
        for (Assunto assuntoClass : assuntos) {
            assunto.addItem(assuntoClass.getDescricao());
        }

        salvar = new JButton("Salvar");

        nome.setPreferredSize(new Dimension(300, 20));

        painel.add(nomeLabel);
        painel.add(nome);
        painel.add(Box.createVerticalStrut(20));
        painel.add(codigoLabel);
        painel.add(codigo);
        painel.add(Box.createVerticalStrut(20));
        painel.add(anoLabel);
        painel.add(ano);
        painel.add(Box.createVerticalStrut(20));
        painel.add(editoraLabel);
        painel.add(editora);
        painel.add(editoraId);
        painel.add(Box.createVerticalStrut(20));
        painel.add(tipoLabel);
        painel.add(tipo);
        painel.add(tipoId);
        painel.add(Box.createVerticalStrut(20));
        painel.add(autorLabel);
        painel.add(autor);
        painel.add(autorId);
        painel.add(Box.createVerticalStrut(20));
        painel.add(assuntoLabel);
        painel.add(assunto);
        painel.add(assuntoId);
        painel.add(Box.createVerticalStrut(20));
        painel.add(salvar);

        editora.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                editoraId.setText(editora.getSelectedIndex() + "");
            }
        });

        tipo.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                tipoId.setText(tipo.getSelectedIndex() + "");
            }
        });

        autor.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                autorId.setText(autor.getSelectedIndex() + "");
            }
        });
        
        assunto.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                assuntoId.setText(assunto.getSelectedIndex() + "");
            }
        });

        salvar.addActionListener(new ActionListener()
        {
            CadastroController controller = new CadastroController();

            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.insertObra(controller.getHashMap(painel));
                nome.setText(null);
                codigo.setText(null);
                ano.setText(null);
                editora.setSelectedIndex(0);
                editoraId.setText(null);
                tipo.setSelectedIndex(0);
                tipoId.setText(null);
                autor.setSelectedIndex(0);
                autorId.setText(null);
                assunto.setSelectedIndex(0);
                assuntoId.setText(null);
            }
        });

        setContentPane(painel);
        pack();
    }

}
