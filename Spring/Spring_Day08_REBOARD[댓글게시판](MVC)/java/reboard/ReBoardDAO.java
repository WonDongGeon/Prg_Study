package reboard;

import java.util.List;

public interface ReBoardDAO {
	public int save(ReBoard reboard); 
	public List<ReBoard> findAll(int startnum, int endnum);
	public ReBoard findById(int d);
	public int update(ReBoard reboard);
	public int delete(int id);
	public int count();
	public int viewcntup(int id);
	public int replySave(ReBoard reboard);
}
