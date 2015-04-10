
package biblioteca.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author maykon
 */
@Entity 
@Table(name = "obraTipo")
@NamedQueries({
    @NamedQuery(name = "ObraTipo.findAll", query = "SELECT o FROM ObraTipo o")})
public class ObraTipo implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<Obra> obraList;

    public ObraTipo()
    {
    }

    public ObraTipo(Integer id)
    {
        this.id = id;
    }

    public ObraTipo(Integer id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public List<Obra> getObraList()
    {
        return obraList;
    }

    public void setObraList(List<Obra> obraList)
    {
        this.obraList = obraList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObraTipo)) {
            return false;
        }
        ObraTipo other = (ObraTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "biblioteca.models.ObraTipo[ id=" + id + " ]";
    }

}
