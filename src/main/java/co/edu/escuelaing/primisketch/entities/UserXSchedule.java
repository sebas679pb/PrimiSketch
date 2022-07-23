package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la asociacion entre usuario y asignatura
 */
@Entity
@Table(name = "UserXSchedule")
public class UserXSchedule {
    
    /**
     * Identificador de la asociacion
     */
    @EmbeddedId
    public PrimaryUxS id;

    /**
     * Constructor de la clase
     */
    public UserXSchedule() {
    }
    
    /**
     * Constructor de la clase
     * @param id Identificador de la asociacion
     */
    public UserXSchedule(PrimaryUxS id) {
        this.id = id;
    }

    /**
     * Constructor de la clase
     * @param idUser Identificador del usuario
     * @param idSchedule Identificador del horario
     */
    public UserXSchedule(Users idUser, Schedules idSchedule) {
        this.id = new PrimaryUxS(idUser, idSchedule);
    }

    // Getters

    /**
     * Getter del identificador de la clase
     * @return Identificador de la asociacion
     */
    public PrimaryUxS getId() {
        return id;
    }

    /**
     * Getter del usuario asociado
     * @return Usuario
     */
    public Users getIdUser() {
        return id.getIdUser();
    }

    /**
     * Getter del horario asociado
     * @return Horario
     */
    public Schedules getIdSchedule() {
        return id.getIdSchedule();
    }

    // Setters

    /**
     * Setter del identificador de la clase
     * @param id Identificador de la asociacion
     */
    public void setId(PrimaryUxS id) {
        this.id = id;
    }
    
    /**
     * Setter del usuario asociado
     * @param idUser Usuario
     */
    public void setIdUser(Users idUser) {
        id.setIdUser(idUser);
    }

    /**
     * Setter del horario asociado
     * @param idSchedule Horario
     */
    public void setIdSchedule(Schedules idSchedule) {
        id.setIdSchedule(idSchedule);
    }
    
}

@Embeddable
class PrimaryUxS implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Users idUser;

    @ManyToOne
    @JoinColumn(name = "idSchedule", nullable = false)
    private Schedules idSchedule;

    public PrimaryUxS() {
    }

    public PrimaryUxS(Users idUser, Schedules idSchedule) {
        this.idUser = idUser;
        this.idSchedule = idSchedule;
    }

    // Getters
    public Users getIdUser() {
        return idUser;
    }

    public Schedules getIdSchedule() {
        return idSchedule;
    }

    // Setters
    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public void setIdSchedule(Schedules idSchedule) {
        this.idSchedule = idSchedule;
    }
    
}
