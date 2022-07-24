package com.yedam.mvcex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.mvcex.boardVO.BoardVO;
import com.yedam.mvcex.boardmapper.BoardMapper;
import com.yedam.mvcex.emp.EmpVO;

@Controller
public class BoardController {

	@Autowired BoardMapper mapper;
	
	//목록
	@RequestMapping("/boardList")
	public String getList(BoardVO vo,Model model) {
		model.addAttribute("boardList",mapper.getBoardList(vo));
		
		return "board/boardList";
	}
	
	//boardInsert페이지 이동
	@RequestMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}
	
	//등록처리 - 포스요청일 때
	@PostMapping("/boardInsert") 
		public String boardInsertProc(BoardVO vo) {
			mapper.boardInsert(vo);
		return "redirect:boardList";
	}
	
	//수정페이지 이동
	@RequestMapping("/boardUpdate")
	public String boardUpdate(Model model, BoardVO vo) {
		vo = mapper.getBoard(vo);
		model.addAttribute("board", vo);
		return "board/boardUpdate";
	}
	
	//수정 처리
	@PostMapping("/boardUpdate")
	public String boardUpdateProc(BoardVO vo) {
		mapper.boardUpdate(vo);
		return "redirect:boardList";
	}
	
	//삭제 처리
	@RequestMapping("/boardDelete")
	public String boardDelete(BoardVO vo) {
		mapper.boardDelete(vo);
		return "redirect:boardList";
	}
	
}
