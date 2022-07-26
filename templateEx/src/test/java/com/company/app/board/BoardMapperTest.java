package com.company.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.board.service.BoardService;
import com.company.app.board.service.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/*.xml")
@Log4j
public class BoardMapperTest {

	
	@Autowired BoardService service;
	
	@Test
	public void insert() {
		for(int i = 0; i < 100; i++) {
		BoardVO vo = new BoardVO();
		vo.setTitle("로그제목");
		vo.setContent("로그콘텐츠");
		vo.setWriter("로그유저");
		service.boardInsert(vo);
		log.info("생성된 게시글 번호 : " + vo.getBno());
		}
	}
	
}
