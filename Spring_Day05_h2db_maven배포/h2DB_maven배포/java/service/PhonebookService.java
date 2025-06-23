package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.PhonebookInter;
import vo.Phonebook;

@Service
public class PhonebookService {
	
	//@Autowired는 직접 new로 생성하는 대신, Spring 컨테이너가 자동으로 관리하고 주입해줍니다. @Autowired는 그 의존 객체를 주입해달라고 요청하는 표시
	@Autowired
	PhonebookInter dao;
	
	public int save(Phonebook phonebook) {
		return dao.save(phonebook);
	}

	@Autowired
	public List<Phonebook> list() {
		return dao.findAll();
	}

	public Object findById(int id) {
		return dao.findById(id);
	}

	public int update(Phonebook phonebook) {
		return dao.update(phonebook);
	}

	public int delete(int id) {
		return dao.delete(id);
	}
}
