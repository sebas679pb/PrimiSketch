package co.edu.escuelaing.primisketch.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa un usuario
 */
@Entity
@Table(name = "Users")
public class Users implements Serializable {

    /**
     * Identificador del usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    /**
     * Columna de nombre del usuario
     */
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    /**
     * Columna de contraseña del usuario
     */
    @Column(name = "passwrd", nullable = false)
    private String passwrd;

    /**
     * Columna de correo del usuario
     */
    @Column(name = "nameUser", nullable = false)
    private String nameUser;

    /**
     * Columna del programa del usuario
     */
    @Column(name = "programa", nullable = true)
    private String programa;

    /**
     * Columna correspondiente al tipo del usuario
     */
    @Column(name = "tipo", nullable = false)
    private String tipo;

    /**
     * Constructor de la clase
     */
    public Users() {
    }

    /**
     * Constructor de la clase
     * @param idUser Identificador del usuario
     * @param username Nombre del usuario
     * @param passwrd Contraseña del usuario
     * @param nameUser Nombre del usuario
     * @param programa Programa del usuario
     * @param tipo Tipo del usuario
     */
    public Users(Long idUser, String username, String passwrd, String nameUser, String programa, String tipo) {
        this.idUser = idUser;
        this.username = username;
        this.passwrd = passwrd;
        this.nameUser = nameUser;
        this.programa = programa;
        this.tipo = tipo;
    }

    // Getters

    /**
     * Getter del identificador del usuario
     * @return Identificador del usuario
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     * Getter del nombre del usuario
     * @return Nombre del usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter de la contraseña del usuario
     * @return Contraseña del usuario
     */
    public String getPasswrd() {
        return passwrd;
    }

    /**
     * Getter del nombre del usuario
     * @return Nombre del usuario
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * Getter del programa del usuario
     * @return Programa del usuario
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Getter del tipo del usuario
     * @return Tipo del usuario
     */
    public String getTipo() {
        return tipo;
    }

    // Setters

    /**
     * Setter del identificador del usuario
     * @param idUser Identificador del usuario
     */
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    /**
     * Setter del nombre del usuario
     * @param username Nombre del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter de la contraseña del usuario
     * @param passwrd Contraseña del usuario
     */
    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    /**
     * Setter del nombre del usuario
     * @param nameUser Nombre del usuario
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * Setter del programa del usuario
     * @param programa Programa del usuario
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * Setter del tipo del usuario
     * @param tipo Tipo del usuario
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Muestra los datos del usuario
     * @return Datos del usuario
     */
    @Override
    public String toString() {
        return "[idUser=" + idUser + ", username=" + username + ", password=" + passwrd + ", name=" + nameUser
                + ", programa=" + programa + ", type=" + tipo + "]";
    }
}
