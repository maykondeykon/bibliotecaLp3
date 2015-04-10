
package biblioteca.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author maykon
 */
@Entity 
@Table(name = "assunto")
@NamedQueries({
    @NamedQuery(name = "Assunto.findAll", query = "SELECT a FROM Assunto a")})
public class Assunto implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @JoinTable(name = "obraAssunto", joinColumns = {
        @JoinColumn(name = "assunto", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "obra", referencedColumnName = "id")})
    @ManyToMany
    private List<Obra> obraList;

    public Assunto()
    {
    }

    public Assunto(Integer id)
    {
        this.id = id;
    }

    public Assunto(Integer id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
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
        if (!(object instanceof Assunto)) {
            return false;
        }
        Assunto other = (Assunto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "biblioteca.models.Assunto[ id=" + id + " ]";
    }

}
