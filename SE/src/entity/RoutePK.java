package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Adam Szaraniec
 */
@Embeddable
public class RoutePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "SOLUTION_ID")
    private int solutionId;

    public RoutePK() {
    }

    public RoutePK(int id, int solutionId) {
        this.id = id;
        this.solutionId = solutionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) solutionId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoutePK)) {
            return false;
        }
        RoutePK other = (RoutePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.solutionId != other.solutionId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoutePK[ id=" + id + ", solutionId=" + solutionId + " ]";
    }
    
}
