package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserXSchedule")
public class UserXSchedule {
    
    @EmbeddedId
    public PrimaryUxS id;

    public UserXSchedule() {
    }

    public UserXSchedule(PrimaryUxS id) {
        this.id = id;
    }

    public UserXSchedule(Users idUser, Schedules idSchedule) {
        this.id = new PrimaryUxS(idUser, idSchedule);
    }

    // Getters
    public PrimaryUxS getId() {
        return id;
    }

    public Users getIdUser() {
        return id.getIdUser();
    }

    public Schedules getIdSchedule() {
        return id.getIdSchedule();
    }

    // Setters
    public void setId(PrimaryUxS id) {
        this.id = id;
    }
    
    public void setIdUser(Users idUser) {
        id.setIdUser(idUser);
    }

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
