package biblioteca.views;

import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author maykon
 */
public abstract class AbstractGui extends JFrame implements ActionListener
{
    JDesktopPane painel;
    int tela = 0;
    int posicao = 30;

    protected void exibeGui(JInternalFrame gui)
    {
        gui.setVisible(true);
        gui.setLocation(tela * posicao, tela * posicao);
        tela++;
        painel.add(gui);

        try {
            gui.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(GuiPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
