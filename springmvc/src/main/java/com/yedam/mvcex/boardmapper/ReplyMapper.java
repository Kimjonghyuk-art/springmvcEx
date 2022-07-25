package com.yedam.mvcex.boardmapper;

import java.util.List;

import com.yedam.mvcex.boardVO.ReplyVO;

public interface ReplyMapper {

	List<ReplyVO> getReplyList(Long bno);
	
	ReplyVO replyRead(Long bno);

	int replyInsert(ReplyVO vo);

	int replyUpdate(ReplyVO vo);

	int replyDelete(Long rno);

}
