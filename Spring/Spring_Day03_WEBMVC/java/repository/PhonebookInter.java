package repository;

import java.util.List;

import vo.Phonebook;

public interface PhonebookInter {
	public int save(Phonebook pb);
	public List<Phonebook> findAll();
	public Phonebook findById(int id);
	//public Phonebook findByName(String name);
	//public Phonebook findByHp(String hp);
	public int update(Phonebook pb);
	public int delete(int id);
}
