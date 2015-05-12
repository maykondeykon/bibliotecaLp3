package biblioteca.views;

import biblioteca.controllers.ConsultaController;
import biblioteca.models.Emprestimo;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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

        modelo = new DefaultTableModel(null, new String[]{"Exemplar", "Data empréstimo", "Usuário", "Funcionário", "Devolver"});
        tabela = new JTable(modelo);
        tabela.setAutoCreateRowSorter(true);
        
        for (Emprestimo emprestimo : emprestimos) {
            Object dados[] = new Object[5];
//            dados[0] = emprestimo.getId().toString();
            dados[0] = emprestimo.getExemplar().getObra().getNome() + " - " + emprestimo.getExemplar().getId();
            dados[1] = emprestimo.getDtaEmprestimo().toString();
            dados[2] = emprestimo.getUsuario().getNome();
            dados[3] = emprestimo.getFuncEmprestimo().getNome();
            dados[4] = emprestimo.getId().toString();

            modelo.addRow(dados);
        }
        
        tabela.getColumn("Devolver").setCellRenderer(new ButtonRenderer());
        tabela.getColumn("Devolver").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        tabPainel = new JScrollPane(tabela);
        painel.add(tabPainel);

        setContentPane(painel);
        pack();
        
        return this;
    }

}

class ButtonRenderer extends JButton implements TableCellRenderer
{

    public ButtonRenderer()
    {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor
{

    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;
    private int row;

    public ButtonEditor(JCheckBox checkBox)
    {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column)
    {
        this.table = table;
        
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue()
    {
        if (isPushed) {
//            JOptionPane.showMessageDialog(button, label + ": Ouch!");
            ConsultaController controller = new ConsultaController();
            int idEmprestimo = Integer.parseInt(label);
            controller.devolveEmprestimo(idEmprestimo);
            ((DefaultTableModel)this.table.getModel()).removeRow(row);//remove linha da tabela
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing()
    {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped()
    {
        super.fireEditingStopped();
    }
}
