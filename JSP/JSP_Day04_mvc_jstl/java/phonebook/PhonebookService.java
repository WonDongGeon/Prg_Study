package phonebook;

import java.util.List;

public class PhonebookService {
	PhonebookDAOH2 dao;
	public PhonebookService() {
		dao = new PhonebookDAOH2();
	}
	public List<Phonebook> findAll() {
		return dao.findAll();
	}
	public int insert(Phonebook phonebook) {
		return dao.insert(phonebook);
	}
	public Phonebook findById(int id) {
		return dao.findById(id);
	}
	public int updateById(Phonebook phonebook) {
		return dao.updateById(phonebook);
	}
	public int deleteById(int id) {
		return dao.deleteById(id);
	}

}
