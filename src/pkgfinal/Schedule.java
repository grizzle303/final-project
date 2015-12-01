/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Garrett
 */
@Entity
@Table(name = "SCHEDULE", catalog = "", schema = "GLAW")
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleid", query = "SELECT s FROM Schedule s WHERE s.scheduleid = :scheduleid"),
    @NamedQuery(name = "Schedule.findByTimeslot", query = "SELECT s FROM Schedule s WHERE s.timeslot = :timeslot")})
public class Schedule implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SCHEDULEID")
    private Integer scheduleid;
    @Column(name = "TIMESLOT")
    private String timeslot;

    public Schedule() {
    }

    public Schedule(Integer scheduleid) {
        this.scheduleid = scheduleid;
    }

    public Integer getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(Integer scheduleid) {
        Integer oldScheduleid = this.scheduleid;
        this.scheduleid = scheduleid;
        changeSupport.firePropertyChange("scheduleid", oldScheduleid, scheduleid);
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        String oldTimeslot = this.timeslot;
        this.timeslot = timeslot;
        changeSupport.firePropertyChange("timeslot", oldTimeslot, timeslot);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleid != null ? scheduleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleid == null && other.scheduleid != null) || (this.scheduleid != null && !this.scheduleid.equals(other.scheduleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgfinal.Schedule[ scheduleid=" + scheduleid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
