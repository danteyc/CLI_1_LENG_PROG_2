package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Subject;

public class MySubjectDaoImpl implements MySubjectDao {
    
    private EntityManagerFactory subjectFactory;
    private EntityManager subjectManager;
    
    public MySubjectDaoImpl() {
        subjectFactory = Persistence.createEntityManagerFactory("MyCL1_Subject");
        subjectManager = subjectFactory.createEntityManager();
    }

    @Override
    public void add(Subject subj) {
            subjectManager.getTransaction().begin();
            subjectManager.persist(subj);
            subjectManager.getTransaction().commit();
    }

    @Override
    public List<Subject> list() {
        Query query = subjectManager.createQuery("SELECT s FROM Subject s"); 
        @SuppressWarnings("unchecked")
        List<Subject> subjectList = query.getResultList();
        return subjectList;
    }

    @Override
    public void modify(Subject subj) {
        try {           
            subjectManager.getTransaction().begin();
            subjectManager.merge(subj);
            subjectManager.getTransaction().commit();
        } catch(Exception e) {
            if (subjectManager.getTransaction().isActive()) {
                subjectManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public void remove(Integer id) {
        try {           
            subjectManager.getTransaction().begin();
            Subject subj = subjectManager.find(Subject.class, id);
            if (subj != null) {
                subjectManager.remove(subj);
            }
            subjectManager.getTransaction().commit();
        } catch(Exception e) {
            if (subjectManager.getTransaction().isActive()) {
                subjectManager.getTransaction().rollback();
            }
            throw e; 
        }
    }
    
    public void closeManager() {
        if (subjectManager != null) {
            subjectManager.close();
        }
        if (subjectFactory != null) {
            subjectFactory.close();
        }
    }

}
