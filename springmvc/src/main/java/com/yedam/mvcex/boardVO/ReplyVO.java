package com.yedam.mvcex.boardVO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ReplyVO {
	private long rno;
	private long bno;
	
	private String reply;
	private String replyer;
	//@JsonAlias(value = "writer")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replyDate;
	@JsonIgnore
	private Date updateDate;
}
