package co.edu.escuelaing.primisketch.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa una asignatura
 */
@Entity
@Table(name = "Subjects")
public class Subjects {

    /**
     * Identificador de la asignatura
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;

    /**
     * Columna de nombre de la asignatura
     */
    @Column(name = "memoSub", nullable = false)
    private String memoSub;

    /**
     * Columna de memotecnico correspondiente a la asignatura
     */
    @Column(name = "nameSub", nullable = false)
    private String nameSub;

    /**
     * Columna del grupo al que corresponde de la asignatura
     */
    @Column(name = "groupSub", nullable = false)
    private Long groupSub;

    /**
     * Columna del profesor correspondiente a la asignatura
     */
    @Column(name = "professor", nullable = false)
    private String professor;

    /**
     * Constructor de la clase
     */
    public Subjects() {
    }

    /**
     * Constructor de la clase
     * @param idSubject Identificador de la asignatura
     * @param memoSub Columna de nombre de la asignatura
     * @param nameSub Columna de memotecnico correspondiente a la asignatura
     * @param groupSub Columna del grupo al que corresponde de la asignatura
     * @param professor Columna del profesor correspondiente a la asignatura
     */
    public Subjects(Long idSubject, String memoSub, String nameSub, Long groupSub, String professor) {
        this.idSubject = idSubject;
        this.memoSub = memoSub;
        this.nameSub = nameSub;
        this.groupSub = groupSub;
        this.professor = professor;
    }

    // Getters
    
    /**
     * Metodo que obtiene el identificador de la asignatura
     * @return Identificador de la asignatura
     */
    public Long getIdSubject() {
        return idSubject;
    }

    /**
     * Metodo que obtiene el nombre de la asignatura
     * @return Nombre de la asignatura
     */
    public String getMemoSub() {
        return memoSub;
    }

    /**
     * Metodo que obtiene el memotecnico correspondiente a la asignatura
     * @return Memotecnico correspondiente a la asignatura
     */
    public String getNameSub() {
        return nameSub;
    }

    /**
     * Metodo que obtiene el grupo al que corresponde de la asignatura
     * @return Grupo al que corresponde de la asignatura
     */
    public Long getGroupSub() {
        return groupSub;
    }

    /**
     * Metodo que obtiene el profesor correspondiente a la asignatura
     * @return Profesor correspondiente a la asignatura
     */
    public String getProfessor() {
        return professor;
    }

    // Setters

    /**
     * Metodo que asigna el identificador de la asignatura
     * @param idSubject Identificador de la asignatura
     */
    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    /**
     * Metodo que asigna el nombre de la asignatura
     * @param memoSub Columna de nombre de la asignatura
     */
    public void setMemoSub(String memoSub) {
        this.memoSub = memoSub;
    }

    /**
     * Metodo que asigna el memotecnico correspondiente a la asignatura
     * @param nameSub Columna de memotecnico correspondiente a la asignatura
     */
    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    /**
     * Metodo que asigna el grupo al que corresponde de la asignatura
     * @param groupSub Columna del grupo al que corresponde de la asignatura
     */
    public void setGroupSub(Long groupSub) {
        this.groupSub = groupSub;
    }

    /**
     * Metodo que asigna el profesor correspondiente a la asignatura
     * @param professor Columna del profesor correspondiente a la asignatura
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * Metodo que obtiene los datos de la asignatura
     * @return Datos de la asignatura
     */
    @Override
    public String toString() {
        return "[idSubject=" + idSubject + ", memo subject=" + memoSub + ", name subject=" + nameSub + ", group="
                + groupSub + ", professor=" + professor + "]";
    }
    
}
