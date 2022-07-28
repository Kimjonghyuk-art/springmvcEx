package com.example.demo.board.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Criteria;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardMapper mapper;
	
	@Override
	public BoardVO getBoard(Long bno) {
		
		return mapper.getBoard(bno);
	}

	@Override
	public int BoardRead(Long bno) {
		
		return mapper.BoardRead(bno);
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		System.out.println("☆★☆★list servcie가 호출되었습니다.☆★☆★");
		return mapper.getBoardList(cri	);
	}

	@Override
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
		
	}

	@Override
	public boolean boardUpdate(BoardVO vo) {
		mapper.boardUpdate(vo);
		return true;
		
	}

	@Override
	public boolean boardDelete(Long bno) {
		mapper.boardDelete(bno);
		return  true;
		/* return mapper.boardDelete(bno) == 1 */
	}

	@Override
	public void insertSelectKey(BoardVO vo) {
		mapper.insertSelectKey(vo);
		
	}

	@Override
	public int getTotalCount(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}

}
