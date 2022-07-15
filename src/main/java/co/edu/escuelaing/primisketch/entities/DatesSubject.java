package co.edu.escuelaing.primisketch.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DatesSubject")
public class DatesSubject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDate;

    @Column(name = "startTime", nullable = false)
    private String startTime;

    @Column(name = "endTime", nullable = false)
    private String endTime;

    @Column(name = "dia", nullable = false)
    private String dia;

    @ManyToOne
    @JoinColumn(name = "idSubject", nullable = false)
    private Subjects idSubjects;

    public DatesSubject() {
    }

    public DatesSubject(int idDate, String startTime, String endTime, String dia, Subjects idSubjects) {
        this.idDate = idDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dia = dia;
        this.idSubjects = idSubjects;
    }

    // Getters
    public int getIdDate() {
        return idDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDia() {
        return dia;
    }

    public Subjects getIdSubjects() {
        return idSubjects;
    }

    // Setters
    public void setIdDate(int idDate) {
        this.idDate = idDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setIdSubjects(Subjects idSubjects) {
        this.idSubjects = idSubjects;
    }

    @Override
    public String toString() {
        return "[idDate=" + idDate + ", start time=" + startTime + ", end time=" + endTime + ", day=" + dia
                + ", idSubject=" + idSubjects + "]";
    }
    
}
