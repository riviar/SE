package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Adam Szaraniec
 */
@Entity
@Table(name = "ROUTE")
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.routePK.id = :id"),
    @NamedQuery(name = "Route.findByData", query = "SELECT r FROM Route r WHERE r.data = :data"),
    @NamedQuery(name = "Route.findBySolutionId", query = "SELECT r FROM Route r WHERE r.routePK.solutionId = :solutionId")})
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoutePK routePK;
    @Column(name = "DATA")
    private String data;
    @JoinColumn(name = "SOLUTION_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Solution solution;

    public Route() {
    }

    public Route(RoutePK routePK) {
        this.routePK = routePK;
    }

    public Route(int id, int solutionId) {
        this.routePK = new RoutePK(id, solutionId);
    }

    public RoutePK getRoutePK() {
        return routePK;
    }

    public void setRoutePK(RoutePK routePK) {
        this.routePK = routePK;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routePK != null ? routePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routePK == null && other.routePK != null) || (this.routePK != null && !this.routePK.equals(other.routePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Route[ routePK=" + routePK + " ]";
    }
    
}
