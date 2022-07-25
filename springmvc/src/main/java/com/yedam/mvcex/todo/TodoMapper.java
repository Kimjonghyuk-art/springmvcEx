package com.yedam.mvcex.todo;

import java.util.List;

import com.yedam.mvcex.todo.TodoVO;

public interface TodoMapper {
	//전체조회
	public List<TodoVO> findAll(TodoVO vo);
	public void persist(TodoVO vo);
	public void merge(TodoVO vo);
	public void remove(int no);
	public TodoVO findById(Integer no);
} 
