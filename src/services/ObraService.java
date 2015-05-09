package services;

import biblioteca.models.Assunto;
import biblioteca.models.Autor;
import biblioteca.models.Obra;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author maykon
 */
public class ObraService extends AbstractService<Obra>
{
    public Obra hydrate(Map<String, String> dados)
    {
        Obra obra = new Obra();
        obra.setNome(dados.get("nome"));
        obra.setAno(dados.get("ano"));
        obra.setCodigo(dados.get("codigo"));
        
        EditoraService editoraServ = new EditoraService();
        Integer editoraId = Integer.parseInt(dados.get("editoraId"));
        obra.setEditora(editoraServ.find(editoraId));
        
        ObraTipoService obraTipoServ = new ObraTipoService();
        Integer tipoId = Integer.parseInt(dados.get("tipoId"));
        obra.setTipo(obraTipoServ.find(tipoId));
        
        
        

        return obra;
    }

    public void insert(Obra obra, Autor autor, Assunto assunto)
    {
        em.getTransaction().begin();
        em.persist(obra);
        
        Query query = em.createNativeQuery("INSERT INTO obraAutor(obra, autor) VALUES(?,?)");
        query.setParameter(1, obra.getId());
        query.setParameter(2, autor.getId());
        query.executeUpdate();
        
        Query query2 = em.createNativeQuery("INSERT INTO obraAssunto(obra, assunto) VALUES(?,?)");
        query2.setParameter(1, obra.getId());
        query2.setParameter(2, assunto.getId());
        query2.executeUpdate();
        
        em.getTransaction().commit();
        em.close();
        
    }

    public List<Obra> findAll()
    {
        Obra obra = new Obra();
        return super.findAll(obra);
    }

    public Obra find(Integer id)
    {
        return em.find(Obra.class, id);
    }

}
