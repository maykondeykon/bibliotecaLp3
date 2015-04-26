package biblioteca.controllers;

import java.awt.Component;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maykon
 */
public abstract class AbstractController
{
    public boolean isValid(Map<String,String> dados)
    {
        for(int i = 0; i < dados.size();i++){
                if (dados.values().equals("")) {
                    return false;
            }
        }

        return true;
    }

}
