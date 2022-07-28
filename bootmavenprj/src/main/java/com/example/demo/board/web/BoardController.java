package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Criteria;
import com.example.demo.common.PageDTO;

@Controller
//@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	/*
	 * @Autowired ReplyMapper remapper;
	 */

	// 상세페이지 이동
	@GetMapping("/get")
	public String get(Model model, BoardVO vo, @RequestParam Long bno) {
//		vo = service.getBoard(bno);
//		model.addAttribute("board", vo);
		model.addAttribute("board", service.getBoard(bno));
		return "board/get";
	}

	// 목록
	@RequestMapping("/boardList") //모델어트리뷰트속성 - 변수명지정 가능
	public String getList(Model model,@ModelAttribute("cri") Criteria cri) {
		//페이징
		//전체 건수
		int total = service.getTotalCount(cri);
		cri.setAmount(5); //한페이지당 5개씩 설정
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("boardList", service.getBoardList(cri));
		//model.addAttribute("criteria", cri); 자동 등록 됨
		return "boardList";
	}

	// boardInsert페이지 이동
	@RequestMapping("/boardInsert")
	public String boardInsert() {
		return "boardInsert";
	}

	// 등록처리 - 포스트요청일 때
	@PostMapping("/boardInsert")
	public String boardInsertProc(BoardVO vo) {
		service.boardInsert(vo);
		return "redirect:boardList";
	}

	// 수정페이지 이동
	@RequestMapping("/boardUpdate")
	public String boardUpdate(Model model, BoardVO vo, @RequestParam Long bno) {
//		vo = service.getBoard(bno);
//		model.addAttribute("board", vo);
		model.addAttribute("board", service.getBoard(bno));
		return "boardUpdate";
	}

	// 수정 처리
	@PostMapping("/boardUpdate")
	public String boardUpdateProc(BoardVO vo, RedirectAttributes rttr) {
		// 성공시 결과 메세지 지정
		if (service.boardUpdate(vo)) {
			rttr.addFlashAttribute("result1", "수정완료되었습니다.");
		}

		return "redirect:boardList";
	}

	// 삭제 처리
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam Long bno, RedirectAttributes rttr) {
		// 성공시 결과 메세지 지정
		if (service.boardDelete(bno)) {
			rttr.addFlashAttribute("result1", "삭제완료되었습니다.");//VIEW페이지에 값으로 날아감 1회성
			rttr.addAttribute("result2", "success"); //주소창에 쿼리문으로 날아감
													//boardList?result=success
		}
		return "redirect:boardList";
	}

}
