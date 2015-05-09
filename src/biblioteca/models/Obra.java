
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author maykon
 */
@Entity 
@Table(name = "obra")
@NamedQueries({
    @NamedQuery(name = "Obra.findAll", query = "SELECT o FROM Obra o")})
public class Obra implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "ano")
    private String ano;
    @ManyToMany(mappedBy = "obraList")
    private List<Assunto> assuntoList;
    @ManyToMany(mappedBy = "obraList", cascade = CascadeType.PERSIST)
    private List<Autor> autorList;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ObraTipo tipo;
    @JoinColumn(name = "editora", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Editora editora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obra")
    private List<Exemplar> exemplarList;

    public Obra()
    {
    }

    public Obra(Integer id)
    {
        this.id = id;
    }

    public Obra(Integer id, String codigo, String nome, String ano)
    {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.ano = ano;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getAno()
    {
        return ano;
    }

    public void setAno(String ano)
    {
        this.ano = ano;
    }

    public List<Assunto> getAssuntoList()
    {
        return assuntoList;
    }

    public void setAssuntoList(List<Assunto> assuntoList)
    {
        this.assuntoList = assuntoList;
    }

    public List<Autor> getAutorList()
    {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList)
    {
        this.autorList = autorList;
    }

    public ObraTipo getTipo()
    {
        return tipo;
    }

    public void setTipo(ObraTipo tipo)
    {
        this.tipo = tipo;
    }

    public Editora getEditora()
    {
        return editora;
    }

    public void setEditora(Editora editora)
    {
        this.editora = editora;
    }

    public List<Exemplar> getExemplarList()
    {
        return exemplarList;
    }

    public void setExemplarList(List<Exemplar> exemplarList)
    {
        this.exemplarList = exemplarList;
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
        if (!(object instanceof Obra)) {
            return false;
        }
        Obra other = (Obra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "biblioteca.models.Obra[ id=" + id + " ]";
    }

}
