package com.yedam.mvcex.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.mvcex.boardVO.ReplyVO;
import com.yedam.mvcex.boardmapper.ReplyMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*.xml")
public class ReplyMapperTest {

	@Autowired ReplyMapper mapper;
	
	@Test
	public void read() {
		long bno = 1;
		ReplyVO result = mapper.replyRead(bno);
		
		System.out.println(result);
	}
	
	@Test
	public void replyInsert() {
		ReplyVO param = new ReplyVO();
		param.setBno(1);
		param.setReply("댓글테스트");
		param.setReplyer("작성자테스트");
		int result = mapper.replyInsert(param);
		System.out.println(result);
	}
	
	
}
