package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @Column(name = "idsubject")
    private int idSubject;

    @Column(name = "subject", length = 45)
    private String subjectName;

    @Column(name = "credits", length = 45)
    private String credits;

    // Getters and Setters

    // Get id Subject
    public int getSubjectId() {
        return idSubject;
    }

    // Set id Subject
    public void setSubjectId(int idSubject) {
        this.idSubject = idSubject;
    }

    // Get name subject
    public String getSubjectName() {
        return subjectName;
    }

    // Set name subject
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // get credits

    public String getCredits() {
        return credits;
    }


    // set credits
    public void setCredits(String credits) {
        this.credits = credits;
    }

}