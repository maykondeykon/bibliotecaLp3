package services;

import biblioteca.models.Assunto;
import biblioteca.models.Autor;
import biblioteca.models.Exemplar;
import biblioteca.models.Obra;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author maykon
 */
public class ExemplarService extends AbstractService<Exemplar>
{
    public Exemplar hydrate(Map<String, String> dados)
    {
        Exemplar exemplar = new Exemplar();
        exemplar.setDtaAquisicao(new Date());
//        
//        EditoraService editoraServ = new EditoraService();
//        Integer editoraId = Integer.parseInt(dados.get("editoraId"));
//        exemplar.setEditora(editoraServ.find(editoraId));
//        
//        ExemplarTipoService exemplarTipoServ = new ExemplarTipoService();
//        Integer tipoId = Integer.parseInt(dados.get("tipoId"));
//        exemplar.setTipo(exemplarTipoServ.find(tipoId));
        
        
        

        return exemplar;
    }

    public void insert(Exemplar exemplar, Obra obra)
    {
        em.getTransaction().begin();
        em.persist(exemplar);
        
//        Query query = em.createNativeQuery("INSERT INTO exemplarAutor(exemplar, autor) VALUES(?,?)");
//        query.setParameter(1, exemplar.getId());
//        query.setParameter(2, autor.getId());
//        query.executeUpdate();
//        
//        Query query2 = em.createNativeQuery("INSERT INTO exemplarAssunto(exemplar, assunto) VALUES(?,?)");
//        query2.setParameter(1, exemplar.getId());
//        query2.setParameter(2, assunto.getId());
//        query2.executeUpdate();
        
        em.getTransaction().commit();
        em.close();
        
    }

    public List<Exemplar> findAll()
    {
        Exemplar exemplar = new Exemplar();
        return super.findAll(exemplar);
    }

    public Exemplar find(Integer id)
    {
        return em.find(Exemplar.class, id);
    }

}
