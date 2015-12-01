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
@Table(name = "PROGRAM", catalog = "", schema = "GLAW")
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByProgramid", query = "SELECT p FROM Program p WHERE p.programid = :programid"),
    @NamedQuery(name = "Program.findByProgramname", query = "SELECT p FROM Program p WHERE p.programname = :programname"),
    @NamedQuery(name = "Program.findByTeacher", query = "SELECT p FROM Program p WHERE p.teacher = :teacher")})
public class Program implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROGRAMID")
    private Integer programid;
    @Column(name = "PROGRAMNAME")
    private String programname;
    @Column(name = "TEACHER")
    private String teacher;

    public Program() {
    }

    public Program(Integer programid) {
        this.programid = programid;
    }

    public Integer getProgramid() {
        return programid;
    }

    public void setProgramid(Integer programid) {
        Integer oldProgramid = this.programid;
        this.programid = programid;
        changeSupport.firePropertyChange("programid", oldProgramid, programid);
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        String oldProgramname = this.programname;
        this.programname = programname;
        changeSupport.firePropertyChange("programname", oldProgramname, programname);
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        String oldTeacher = this.teacher;
        this.teacher = teacher;
        changeSupport.firePropertyChange("teacher", oldTeacher, teacher);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programid != null ? programid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.programid == null && other.programid != null) || (this.programid != null && !this.programid.equals(other.programid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkgfinal.Program[ programid=" + programid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
