package com.yedam.mvcex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.mvcex.boardVO.ReplyVO;
import com.yedam.mvcex.boardmapper.ReplyMapper;

@RestController
public class ReplyController {
	@Autowired ReplyMapper mapper;
	
	//단건 조회 get
	@GetMapping("/reply/{rno}")
	public ReplyVO todoSelect(@PathVariable Long rno) {
		return mapper.replyRead(rno);
	}
	
	//전체 조회
	@GetMapping("/getReplyList/{bno}")
	public List<ReplyVO> getReplyList(@PathVariable Long bno) {
		return mapper.getReplyList(bno);
	}
	
	//등록 post
	@PostMapping("/reply")
	public ReplyVO replyInsert(ReplyVO vo) {
		mapper.replyInsert(vo);
		return vo;
	}
	//수정 put
	@PutMapping("/reply")
	public ReplyVO replyUpdate(@RequestBody ReplyVO vo) {
		mapper.replyUpdate(vo);
		return vo;
	}

	//삭제 delete
	@DeleteMapping("/reply/{rno}")
	public Long replyDelete(@PathVariable Long rno) {
		mapper.replyDelete(rno);
		return rno;
	}

	
}
