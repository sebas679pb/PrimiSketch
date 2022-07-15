package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Schedules")
public class Schedules implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSchedule;

    @Column(name = "creationDate", nullable = false)
    private Date creationDate;

    public Schedules() {
    }

    public Schedules(long idSchedule, Date creationDate) {
        this.idSchedule = idSchedule;
        this.creationDate = creationDate;
    }

    // Getters
    public long getIdSchedule() {
        return idSchedule;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setIdSchedule(long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "[idSchedule=" + idSchedule + ", creation date=" + creationDate + "]";
    }
    
}
