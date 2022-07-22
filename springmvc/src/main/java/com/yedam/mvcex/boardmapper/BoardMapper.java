package com.yedam.mvcex.boardmapper;

import java.util.List;

import com.yedam.mvcex.boardVO.BoardVO;

public interface BoardMapper {

	public List<BoardVO> getList();
	
	public void insert(BoardVO vo);
	
	public void insertSelectKey(BoardVO vo);
	
}
