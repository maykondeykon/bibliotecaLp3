package services;

import biblioteca.models.Usuario;
import java.util.Map;

/**
 *
 * @author maykon
 */
public class UsuarioService extends AbstractService<Usuario>
{
    public Usuario hydrate(Map<String, String> dados)
    {
        Usuario usuario = new Usuario();
        usuario.setNome(dados.get("nome"));
        usuario.setEndereco(dados.get("endereco"));
        usuario.setTelefone(dados.get("telefone"));

        return usuario;
    }

    @Override
    public void insert(Usuario usuario)
    {
        super.insert(usuario);
    }

}
