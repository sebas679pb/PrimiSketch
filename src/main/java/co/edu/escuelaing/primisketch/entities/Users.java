package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "passwrd", nullable = false)
    private String passwrd;

    @Column(name = "nameUser", nullable = false)
    private String nameUser;

    @Column(name = "programa", nullable = true)
    private String programa;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public Users() {
    }

    public Users(int idUser, String username, String passwrd, String nameUser, String programa, String tipo) {
        this.idUser = idUser;
        this.username = username;
        this.passwrd = passwrd;
        this.nameUser = nameUser;
        this.programa = programa;
        this.tipo = tipo;
    }

    // Getters
    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPrograma() {
        return programa;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "[idUser=" + idUser + ", username=" + username + ", password=" + passwrd + ", name=" + nameUser
                + ", programa=" + programa + ", type=" + tipo + "]";
    }
}
