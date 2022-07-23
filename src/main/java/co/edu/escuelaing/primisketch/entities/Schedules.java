package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

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
    private Long idSchedule;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    public Schedules() {
    }

    public Schedules(Long idSchedule, String nombre) {
        this.idSchedule = idSchedule;
        this.nombre = nombre;
    }

    public Schedules(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    public Long getIdSchedule() {
        return idSchedule;
    }

    public String getNombre() {
        return nombre;
    }

    // Setters
    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "[idSchedule=" + idSchedule + ", name=" + nombre + "]";
    }

}
