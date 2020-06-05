/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HZ
 */
@Entity
@Table(name = "survey")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Survey.findAll", query = "SELECT s FROM Survey s")
    , @NamedQuery(name = "Survey.findById", query = "SELECT s FROM Survey s WHERE s.id = :id")
    , @NamedQuery(name = "Survey.findByNama", query = "SELECT s FROM Survey s WHERE s.nama = :nama")
    , @NamedQuery(name = "Survey.findByJurusan", query = "SELECT s FROM Survey s WHERE s.jurusan = :jurusan")
    , @NamedQuery(name = "Survey.findByAlamat", query = "SELECT s FROM Survey s WHERE s.alamat = :alamat")
    , @NamedQuery(name = "Survey.findByTelp", query = "SELECT s FROM Survey s WHERE s.telp = :telp")
    , @NamedQuery(name = "Survey.findByMinat", query = "SELECT s FROM Survey s WHERE s.minat = :minat")})
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NAMA")
    private String nama;
    @Size(max = 30)
    @Column(name = "JURUSAN")
    private String jurusan;
    @Size(max = 100)
    @Column(name = "ALAMAT")
    private String alamat;
    @Size(max = 20)
    @Column(name = "TELP")
    private String telp;
    @Size(max = 20)
    @Column(name = "MINAT")
    private String minat;

    public Survey() {
    }

    public Survey(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Survey)) {
            return false;
        }
        Survey other = (Survey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "survey.Survey[ id=" + id + " ]";
    }
    
}
