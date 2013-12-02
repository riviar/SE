package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Adam Szaraniec
 */
@Entity
@Table(name = "SOLUTION")
@NamedQueries({
    @NamedQuery(name = "Solution.findAll", query = "SELECT s FROM Solution s"),
    @NamedQuery(name = "Solution.findById", query = "SELECT s FROM Solution s WHERE s.id = :id"),
    @NamedQuery(name = "Solution.findByAuthors", query = "SELECT s FROM Solution s WHERE s.authors = :authors"),
    @NamedQuery(name = "Solution.findByDate", query = "SELECT s FROM Solution s WHERE s.date = :date"),
    @NamedQuery(name = "Solution.findByNumberofvehicles", query = "SELECT s FROM Solution s WHERE s.numberofvehicles = :numberofvehicles"),
    @NamedQuery(name = "Solution.findByCapacity", query = "SELECT s FROM Solution s WHERE s.capacity = :capacity")})
public class Solution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "AUTHORS")
    private String authors;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "NUMBEROFVEHICLES")
    private Integer numberofvehicles;
    @Column(name = "CAPACITY")
    private Integer capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solution", fetch = FetchType.EAGER)
    private Collection<Route> routeCollection;

    public Solution() {
        routeCollection = new ArrayList<Route>();
    }

    public Solution(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumberofvehicles() {
        return numberofvehicles;
    }

    public void setNumberofvehicles(Integer numberofvehicles) {
        this.numberofvehicles = numberofvehicles;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Collection<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }
    
    public void addRoute(Route route) {
        this.routeCollection.add(route);
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
        if (!(object instanceof Solution)) {
            return false;
        }
        Solution other = (Solution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Solution[ id=" + id + " ]";
    }
    
}
