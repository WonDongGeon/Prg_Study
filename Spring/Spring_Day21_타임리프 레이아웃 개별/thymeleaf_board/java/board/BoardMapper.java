package board;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardMapper {
	public int save(Board board);
	public List<Board> findAll(@Param("startnum") int startnum, @Param("endnum") int endnum);
	public Board findById(int id);
	public int update(Board board);
	public int delete(int id); 
	public int count();
	public int viewcntup(int id);
}
