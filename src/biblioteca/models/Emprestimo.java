
package biblioteca.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maykon
 */
@Entity 
@Table(name = "emprestimo")
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e")})
public class Emprestimo implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dtaEmprestimo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaEmprestimo;
    @Column(name = "dtaDevolucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaDevolucao;
    @Column(name = "funcDevolucao")
    private Integer funcDevolucao;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "funcEmprestimo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcEmprestimo;
    @JoinColumn(name = "exemplar", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Exemplar exemplar;

    public Emprestimo()
    {
    }

    public Emprestimo(Integer id)
    {
        this.id = id;
    }

    public Emprestimo(Integer id, Date dtaEmprestimo)
    {
        this.id = id;
        this.dtaEmprestimo = dtaEmprestimo;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getDtaEmprestimo()
    {
        return dtaEmprestimo;
    }

    public void setDtaEmprestimo(Date dtaEmprestimo)
    {
        this.dtaEmprestimo = dtaEmprestimo;
    }

    public Date getDtaDevolucao()
    {
        return dtaDevolucao;
    }

    public void setDtaDevolucao(Date dtaDevolucao)
    {
        this.dtaDevolucao = dtaDevolucao;
    }

    public Integer getFuncDevolucao()
    {
        return funcDevolucao;
    }

    public void setFuncDevolucao(Integer funcDevolucao)
    {
        this.funcDevolucao = funcDevolucao;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Funcionario getFuncEmprestimo()
    {
        return funcEmprestimo;
    }

    public void setFuncEmprestimo(Funcionario funcEmprestimo)
    {
        this.funcEmprestimo = funcEmprestimo;
    }

    public Exemplar getExemplar()
    {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar)
    {
        this.exemplar = exemplar;
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
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "biblioteca.models.Emprestimo[ id=" + id + " ]";
    }

}
