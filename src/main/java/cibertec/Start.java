package cibertec;

import dao.MySubjectDaoImpl;
import model.Subject;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        MySubjectDaoImpl subjectDataAccessObject = new MySubjectDaoImpl();

        Subject newSubjectRecord = new Subject();
        newSubjectRecord.setSubjectId(2);
        newSubjectRecord.setCredits("4");
        newSubjectRecord.setSubjectName("Análisis y diseño de sistemas");

        subjectDataAccessObject.add(newSubjectRecord);

        List<Subject> retrievedSubjects = subjectDataAccessObject.list();
        for (Subject subject : retrievedSubjects) {
            System.out.println("Materia: " + subject.getSubjectName());
            System.out.println(", Créditos: " + subject.getCredits());
        }

        newSubjectRecord.setCredits("5"); 
        subjectDataAccessObject.modify(newSubjectRecord);
        System.out.println("Materia actualizada...");

        subjectDataAccessObject.remove(newSubjectRecord.getSubjectId());
        System.out.println("Materia eliminada");

        subjectDataAccessObject.closeManager();

    }
}
