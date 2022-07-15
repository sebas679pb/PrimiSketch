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

    public UserXSchedule(Subjects idUser, Schedules idSchedule) {
        this.id = new PrimaryUxS(idUser, idSchedule);
    }

    // Getters
    public PrimaryUxS getId() {
        return id;
    }

    public Subjects getIdUser() {
        return id.getIdUser();
    }

    public Schedules getIdSchedule() {
        return id.getIdSchedule();
    }

    // Setters
    public void setId(PrimaryUxS id) {
        this.id = id;
    }
    
    public void setIdUser(Subjects idUser) {
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
    private Subjects idUser;

    @ManyToOne
    @JoinColumn(name = "idSchedule", nullable = false)
    private Schedules idSchedule;

    public PrimaryUxS() {
    }

    public PrimaryUxS(Subjects idUser, Schedules idSchedule) {
        this.idUser = idUser;
        this.idSchedule = idSchedule;
    }

    // Getters
    public Subjects getIdUser() {
        return idUser;
    }

    public Schedules getIdSchedule() {
        return idSchedule;
    }

    // Setters
    public void setIdUser(Subjects idUser) {
        this.idUser = idUser;
    }

    public void setIdSchedule(Schedules idSchedule) {
        this.idSchedule = idSchedule;
    }
    
}
