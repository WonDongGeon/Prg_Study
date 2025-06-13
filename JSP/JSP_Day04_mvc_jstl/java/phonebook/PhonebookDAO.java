package phonebook;

import java.util.List;

public interface PhonebookDAO {
	//입력
			public int insert(Phonebook pb);
				
			//전체출력
			public List<Phonebook> findAll();
				
			//선택출력 
			public Phonebook findById(int id);
			
			//수정
			public int updateById(Phonebook bp);
				
			//삭제
			public int deleteById(int id);
}
