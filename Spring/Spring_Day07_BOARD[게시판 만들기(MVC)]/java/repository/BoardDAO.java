package repository;

import java.util.List;

import vo.Board;

public interface BoardDAO {
	public int save(Board board); 
	public List<Board> findAll(int statnum, int endnum); 
	public Board FindById(int id); 
	public int update(Board board); 
	public int delete(int id); 
	public int count();
}
