package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa un horario
 */
@Entity
@Table(name = "Schedules")
public class Schedules implements Serializable {
    
    /**
     * Identificador del horario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchedule;

    /**
     * Dia del horario
     */
    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    /**
     * Constructor de la clase
     */
    public Schedules() {
    }

    /**
     * Constructor de la clase
     * @param idSchedule Identificador del horario
     * @param nombre Nombre del horario
     */
    public Schedules(Long idSchedule, String nombre) {
        this.idSchedule = idSchedule;
        this.nombre = nombre;
    }

    /**
     * Constructor de la clase
     * @param nombre Nombre del horario
     */
    public Schedules(String nombre) {
        this.nombre = nombre;
    }

    // Getters

    /**
     * Getter del identificador del horario
     * @return Identificador del horario
     */
    public Long getIdSchedule() {
        return idSchedule;
    }

    /**
     * Getter del nombre del horario
     * @return Nombre del horario
     */
    public String getNombre() {
        return nombre;
    }

    // Setters

    /**
     * Setter del identificador del horario
     * @param idSchedule Identificador del horario
     */
    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    /**
     * Setter del nombre del horario
     * @param nombre Nombre del horario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Muestra los datos del horario
     * @return Datos del horario
     */
    @Override
    public String toString() {
        return "[idSchedule=" + idSchedule + ", name=" + nombre + "]";
    }

}
