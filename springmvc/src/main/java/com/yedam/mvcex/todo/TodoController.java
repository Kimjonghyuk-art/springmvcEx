package com.yedam.mvcex.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") //CORS 에러처리 모든 도메인의 요청을 받겠다
public class TodoController {

	@Autowired
	TodoMapper mapper;

	// 조회 => Get
	@GetMapping(value = "/todo", produces = {
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TodoVO>> todoList(TodoVO vo) {
		//int a = 5/0;
		List<TodoVO> list = mapper.findAll(vo); 
		return new ResponseEntity<List<TodoVO>>(list,
				HttpStatus.OK);//결과값,상태값 OK = 200, NOTFOUND = 404
	}

	// 등록 => Post
	@PostMapping("/todo")
	public TodoVO todoInsert(TodoVO vo) {
		mapper.persist(vo);
		return vo;
	}

	// 수정 => Put **(JSON만 가능!!)**
	@PutMapping("/todo") //파라미터가 JSON이라 파싱필요
	public TodoVO todoUpdate(@RequestBody TodoVO vo) {
		System.out.println(vo);
		mapper.merge(vo);
		
		return vo;
	}

	// 삭제 => DELETE
	@DeleteMapping("/todo/{no}")
	public Integer todoDelete(@PathVariable Integer no) {
		mapper.remove(no);
		return no;
	}

	// 단건조회 => GET
	@GetMapping("/todo/{no}")
	public TodoVO todoSelect(@PathVariable Integer no) {
		
		return mapper.findById(no);
	}
	
	//단순 문자열 반환
	@GetMapping(value= "/getText", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getText() {
		
		return "한글한글";
	}
	
	@GetMapping("/check")
	public List<TodoVO> check(TodoVO vo) {
		int a = 5/0;
		return mapper.findAll(vo);
	}
	
	
	
	
	
	
}
