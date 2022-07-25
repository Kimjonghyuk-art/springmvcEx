package com.yedam.mvcex.boardmapper;

import java.util.List;

import com.yedam.mvcex.boardVO.BoardVO;

public interface BoardMapper {

	BoardVO getBoard(BoardVO vo);
	int BoardRead(Long bno);
	
	public List<BoardVO> getBoardList(BoardVO vo);
	
	public void boardInsert(BoardVO vo);
	
	public void boardUpdate(BoardVO vo);
	
	void boardDelete(BoardVO vo);
	
	public void insertSelectKey(BoardVO vo);
	
}
