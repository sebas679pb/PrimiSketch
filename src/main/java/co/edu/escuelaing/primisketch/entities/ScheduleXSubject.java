package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la asociacion entre horario y asignatura
 */
@Entity
@Table(name = "ScheduleXSubject")
public class ScheduleXSubject {

    /**
     * Identificador de la asignatura
     */
    @EmbeddedId
    public PrimarySxS id;

    /**
     * Constructor de la clase
     */
    public ScheduleXSubject() {
    }

    /**
     * Constructor de la clase
     * @param id Identificador de la asignatura
     */
    public ScheduleXSubject(PrimarySxS id) {
        this.id = id;
    }

    /**
     * Constructor de la clase
     * @param idSchedule Identificador de la asignatura
     * @param idSubject Identificador de la asignatura
     */
    public ScheduleXSubject(Schedules idSchedule, Subjects idSubject) {
        this.id = new PrimarySxS(idSchedule, idSubject);
    }

    // Getters

    /**
     * Getter del identificador de la clase
     * @return Identificador de la asignatura
     */
    public PrimarySxS getId() {
        return id;
    }

    /**
     * Getter del horario
     * @return Horario
     */
    public Schedules getIdSchedule() {
        return id.getIdSchedule();
    }

    /**
     * Getter de la asignatura
     * @return Asignatura
     */
    public Subjects getIdSubject() {
        return id.getIdSubject();
    }

    // Setters

    /**
     * Setter del identificador de la clase
     * @param id Identificador de la clase
     */
    public void setId(PrimarySxS id) {
        this.id = id;
    }

    /**
     * Setter del horario asociado
     * @param idSchedule Horario
     */
    public void setIdSchedule(Schedules idSchedule) {
        id.setIdSchedule(idSchedule);
    }

    /**
     * Setter de la asignatura asociada
     * @param idSubject Asignatura
     */
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
