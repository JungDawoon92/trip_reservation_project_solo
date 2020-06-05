package board.dao;

import java.util.List;

import board.dto.BoardDto;

public interface BoardDao {
	public List list();
	public BoardDto findBySeq(int seq);
	public void insert(BoardDto dto);
	public void update(BoardDto dto);
	public void delete(int seq);
}
