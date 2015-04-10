
package biblioteca.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maykon
 */
@Entity 
@Table(name = "exemplar")
@NamedQueries({
    @NamedQuery(name = "Exemplar.findAll", query = "SELECT e FROM Exemplar e")})
public class Exemplar implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dtaAquisicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaAquisicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exemplar")
    private List<Emprestimo> emprestimoList;
    @JoinColumn(name = "obra", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Obra obra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exemplar")
    private List<Reserva> reservaList;

    public Exemplar()
    {
    }

    public Exemplar(Integer id)
    {
        this.id = id;
    }

    public Exemplar(Integer id, Date dtaAquisicao)
    {
        this.id = id;
        this.dtaAquisicao = dtaAquisicao;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getDtaAquisicao()
    {
        return dtaAquisicao;
    }

    public void setDtaAquisicao(Date dtaAquisicao)
    {
        this.dtaAquisicao = dtaAquisicao;
    }

    public List<Emprestimo> getEmprestimoList()
    {
        return emprestimoList;
    }

    public void setEmprestimoList(List<Emprestimo> emprestimoList)
    {
        this.emprestimoList = emprestimoList;
    }

    public Obra getObra()
    {
        return obra;
    }

    public void setObra(Obra obra)
    {
        this.obra = obra;
    }

    public List<Reserva> getReservaList()
    {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList)
    {
        this.reservaList = reservaList;
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
        if (!(object instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "biblioteca.models.Exemplar[ id=" + id + " ]";
    }

}
