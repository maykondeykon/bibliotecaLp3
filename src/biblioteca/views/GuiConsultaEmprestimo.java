package biblioteca.views;

import biblioteca.models.Emprestimo;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maykon
 */
public class GuiConsultaEmprestimo extends JInternalFrame
{

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane tabPainel;

    public GuiConsultaEmprestimo()
    {
        super("Empréstimos", true, true, false, true);
        this.setPreferredSize(new java.awt.Dimension(800, 400));
    }

    public JInternalFrame listaEmprestimos(List<Emprestimo> emprestimos)
    {
        final JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.PAGE_AXIS));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        modelo = new DefaultTableModel(null, new String[]{"ID", "Exemplar", "Data empréstimo", "Usuário", "Funcionário"});
        tabela = new JTable(modelo);
        tabela.setAutoCreateRowSorter(true);

        for (Emprestimo emprestimo : emprestimos) {
            String dados[] = new String[5];
            dados[0] = emprestimo.getId().toString();
            dados[1] = emprestimo.getExemplar().getObra().getNome() + " - " + emprestimo.getExemplar().getId();
            dados[2] = emprestimo.getDtaEmprestimo().toString();
            dados[3] = emprestimo.getUsuario().getNome();
            dados[4] = emprestimo.getFuncEmprestimo().getNome();

            modelo.addRow(dados);
        }

        tabPainel = new JScrollPane(tabela);
        painel.add(tabPainel);

        setContentPane(painel);
        pack();
        
        return this;
    }

}
