package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Criteria;


public interface BoardMapper {

	BoardVO getBoard(Long bno);
	int BoardRead(Long bno);
	
	public List<BoardVO> getBoardList(Criteria cri);
	
	public void boardInsert(BoardVO vo);
	
	public void boardUpdate(BoardVO vo);
	
	void boardDelete(Long bno);
	
	public void insertSelectKey(BoardVO vo);
	
	//전체 게시글 수
	int getTotalCount(Criteria cri);
	
}
