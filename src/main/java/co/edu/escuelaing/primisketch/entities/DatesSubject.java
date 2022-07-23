package co.edu.escuelaing.primisketch.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa los horarios de una asignatura
 */
@Entity
@Table(name = "DatesSubject")
public class DatesSubject {
    
    /**
     * Identificador de la asignatura
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDate;

    /**
     * Columna de tiempo de inicio de la asignatura
     */
    @Column(name = "startTime", nullable = false)
    private String startTime;

    /**
     * Columna de tiempo de fin de la asignatura
     */
    @Column(name = "endTime", nullable = false)
    private String endTime;

    /**
     * Columna de dia de la asignatura
     */
    @Column(name = "dia", nullable = false)
    private String dia;

    /**
     * Columna que asocia el horario con la asignatura
     */
    @ManyToOne
    @JoinColumn(name = "idSubject", nullable = false)
    private Subjects idSubjects;

    /**
     * Constructor de la clase
     */
    public DatesSubject() {
    }

    /**
     * Constructor de la clase
     * @param idDate Identificador de la asignatura
     * @param startTime Columna de tiempo de inicio de la asignatura
     * @param endTime Columna de tiempo de fin de la asignatura
     * @param dia Columna de dia de la asignatura
     * @param idSubjects Columna que asocia el horario con la asignatura
     */
    public DatesSubject(Long idDate, String startTime, String endTime, String dia, Subjects idSubjects) {
        this.idDate = idDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dia = dia;
        this.idSubjects = idSubjects;
    }

    // Getters
    
    /**
     * Metodo que obtiene el identificador de la asignatura
     * @return Identificador de la asignatura
     */
    public Long getIdDate() {
        return idDate;
    }

    /**
     * Metodo que obtiene el tiempo de inicio de la asignatura
     * @return Tiempo de inicio de la asignatura
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Metodo que obtiene el tiempo de fin de la asignatura
     * @return Tiempo de fin de la asignatura
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Metodo que obtiene el dia de la asignatura
     * @return Dia de la asignatura
     */
    public String getDia() {
        return dia;
    }

    /**
     * Metodo que obtiene la asignatura asociada al horario
     * @return Asignatura asociada al horario
     */
    public Subjects getIdSubjects() {
        return idSubjects;
    }

    // Setters

    /**
     * Metodo que modifica el identificador de la asignatura
     * @param idDate Identificador de la asignatura
     */
    public void setIdDate(Long idDate) {
        this.idDate = idDate;
    }

    /**
     * Metodo que modifica el tiempo de inicio de la asignatura
     * @param startTime Tiempo de inicio de la asignatura
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Metodo que modifica el tiempo de fin de la asignatura
     * @param endTime Tiempo de fin de la asignatura
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Metodo que modifica el dia de la asignatura
     * @param dia Dia de la asignatura
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Metodo que modifica la asignatura asociada al horario
     * @param idSubjects Asignatura asociada al horario
     */
    public void setIdSubjects(Subjects idSubjects) {
        this.idSubjects = idSubjects;
    }

    /**
     * Muestra los datos de la clase
     * @return Datos de la asignatura
     */
    @Override
    public String toString() {
        return "[idDate=" + idDate + ", start time=" + startTime + ", end time=" + endTime + ", day=" + dia
                + ", idSubject=" + idSubjects + "]";
    }
    
}
