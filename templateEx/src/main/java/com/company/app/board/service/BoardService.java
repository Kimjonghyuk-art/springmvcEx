package com.company.app.board.service;

import java.util.List;

import com.company.app.common.Criteria;

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
