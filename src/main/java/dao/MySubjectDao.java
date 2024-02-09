package dao;

import java.util.List;

import model.Subject;

public interface MySubjectDao {

	public void add(Subject s);
	public List<Subject> list();
	public void modify(Subject s);
	public void remove(Integer id);
}
