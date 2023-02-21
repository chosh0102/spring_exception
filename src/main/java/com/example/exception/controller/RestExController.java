package com.example.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.errorModel.ErrorResult;
import com.example.exception.errorModel.UserException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestExController {

	
	@GetMapping("api/string")
	public String getString() {
		log.info("api/string の呼び出し");
		return "Hello World";
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler
//	public ErrorResult illegalExHandle(IllegalArgumentException e) {
//		log.info("ex: {}",e.getMessage());
//		return new ErrorResult("BAD REQUEST",e.getMessage());
//	}	//ErrorResultを作成後、ResponseEntityに溜める。
//	
//	@ExceptionHandler
//	public ResponseEntity<ErrorResult> userExHandle(UserException e){
//		log.info("ex:{}",e.getMessage());
//		ErrorResult result=new ErrorResult("USER-EX", e.getMessage());
//		return new ResponseEntity<ErrorResult>(result, HttpStatus.BAD_REQUEST);
//	}
//	@ExceptionHandler
//	public ResponseEntity<ErrorResult> exHandle(Exception e){
//		log.info("ex:{}",e.getMessage());
//		ErrorResult result=new ErrorResult("EX", e.getMessage());
//		return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@GetMapping("api/members/{id}")
	public Member getMember(@PathVariable(name="id") String id) throws Exception {
		if(id.equals("error")) {
			throw new RuntimeException("間違ったユーザー");
		}
		if(id.equals("badreq")) {
			throw new IllegalArgumentException("間違った呼び出し");
		}
		if(id.equals("user-ex")) {
			throw new UserException("ユーザー定義エラー");
		}
		if(id.equals("exception")) {
			throw new Exception("その他例外");
		}
		return new Member(id,"山田太郎");
		}
	
	@Data
	@AllArgsConstructor
static class Member{
	private String memberId;
	private String name;
}
	}

