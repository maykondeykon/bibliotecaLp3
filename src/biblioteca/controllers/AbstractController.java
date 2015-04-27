package biblioteca.controllers;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author maykon
 */
public abstract class AbstractController
{

    public boolean isValid(Map<String, String> dados)
    {
        Set<String> chaves = dados.keySet();
        for (String chave : chaves) {
            if (dados.get(chave).equals("")) {
                return false;
            }
        }

        return true;
    }

    public Map<String, String> getHashMap(JPanel painel)
    {
        Map<String, String> fields = new HashMap();

        for (Component c : painel.getComponents()) {
            if (c instanceof JTextField) {
                fields.put(((JTextField) c).getName(), ((JTextField) c).getText());
            }
        }

        return fields;
    }

}
