package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ScheduleXSubject")
public class ScheduleXSubject {

    @EmbeddedId
    public PrimarySxS id;

    public ScheduleXSubject() {
    }

    public ScheduleXSubject(PrimarySxS id) {
        this.id = id;
    }

    public ScheduleXSubject(Schedules idSchedule, Subjects idSubject) {
        this.id = new PrimarySxS(idSchedule, idSubject);
    }

    // Getters
    public PrimarySxS getId() {
        return id;
    }

    public Schedules getIdSchedule() {
        return id.getIdSchedule();
    }

    public Subjects getIdSubject() {
        return id.getIdSubject();
    }

    // Setters
    public void setId(PrimarySxS id) {
        this.id = id;
    }

    public void setIdSchedule(Schedules idSchedule) {
        id.setIdSchedule(idSchedule);
    }

    public void setIdSubject(Subjects idSubject) {
        id.setIdSubject(idSubject);
    }
    
}

@Embeddable
class PrimarySxS implements Serializable{

    @ManyToOne
    @JoinColumn(name = "idSchedule", nullable = false)
    private Schedules idSchedule;

    @ManyToOne
    @JoinColumn(name = "idSubject", nullable = false)
    private Subjects idSubject;

    public PrimarySxS() {
    }

    public PrimarySxS(Schedules idSchedule, Subjects idSubject) {
        this.idSchedule = idSchedule;
        this.idSubject = idSubject;
    }

    // Getters
    public Schedules getIdSchedule() {
        return idSchedule;
    }

    public Subjects getIdSubject() {
        return idSubject;
    }

    // Setters
    public void setIdSchedule(Schedules idSchedule) {
        this.idSchedule = idSchedule;
    }

    public void setIdSubject(Subjects idSubject) {
        this.idSubject = idSubject;
    }

}
