/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.MVCcdshop.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Grant
 */
@Entity
@Table(name = "USERSROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersrole.findAll", query = "SELECT u FROM Usersrole u"),
    @NamedQuery(name = "Usersrole.findByRoleid", query = "SELECT u FROM Usersrole u WHERE u.roleid = :roleid"),
    @NamedQuery(name = "Usersrole.findByRolename", query = "SELECT u FROM Usersrole u WHERE u.rolename = :rolename")})
public class Usersrole implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ROLEID")
    private Integer roleid;
    @Basic(optional = false)
    @Column(name = "ROLENAME")
    private String rolename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersrole")
    private Collection<Users> usersCollection;

    public Usersrole() {
    }

    public Usersrole(Integer roleid) {
        this.roleid = roleid;
    }

    public Usersrole(Integer roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usersrole)) {
            return false;
        }
        Usersrole other = (Usersrole) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.MVCcdshop.Entities.Usersrole[ roleid=" + roleid + " ]";
    }
    
}
