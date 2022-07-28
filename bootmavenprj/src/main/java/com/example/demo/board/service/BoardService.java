package com.example.demo.board.service;

import java.util.List;

import com.example.demo.common.Criteria;


public interface BoardService {

	BoardVO getBoard(Long bno);

	int BoardRead(Long bno);

	List<BoardVO> getBoardList(Criteria cri);

	void boardInsert(BoardVO vo);

	boolean boardUpdate(BoardVO vo);

	boolean boardDelete(Long bno);

	void insertSelectKey(BoardVO vo);

	//전체 게시글 수
	int getTotalCount(Criteria cri);
}
