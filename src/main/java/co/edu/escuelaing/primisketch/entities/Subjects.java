package co.edu.escuelaing.primisketch.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;

    @Column(name = "memoSub", nullable = false)
    private String memoSub;

    @Column(name = "nameSub", nullable = false)
    private String nameSub;

    @Column(name = "groupSub", nullable = false)
    private String groupSub;

    @Column(name = "professor", nullable = false)
    private String professor;

    public Subjects() {
    }

    public Subjects(Long idSubject, String memoSub, String nameSub, String groupSub, String professor) {
        this.idSubject = idSubject;
        this.memoSub = memoSub;
        this.nameSub = nameSub;
        this.groupSub = groupSub;
        this.professor = professor;
    }

    // Getters
    public Long getIdSubject() {
        return idSubject;
    }

    public String getMemoSub() {
        return memoSub;
    }

    public String getNameSub() {
        return nameSub;
    }

    public String getGroupSub() {
        return groupSub;
    }

    public String getProfessor() {
        return professor;
    }

    // Setters
    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public void setMemoSub(String memoSub) {
        this.memoSub = memoSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public void setGroupSub(String groupSub) {
        this.groupSub = groupSub;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "[idSubject=" + idSubject + ", memo subject=" + memoSub + ", name subject=" + nameSub + ", group="
                + groupSub + ", professor=" + professor + "]";
    }
    
}
