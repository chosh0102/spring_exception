package com.example.exception.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServletExController {

//	400番代エラー：クライアントが間違った要請を行った場合。
//	500番代エラー：サバ－で処理を行う中で発生するエラー

//	Exception処理の流れ：コントロールから発生　→インタセプター　→　サブリット→フィルター	→WAS
/*
エラー処理方法：	
1.throw Exception
2.response.sendError(HTTP状態コード,エラーメッセージ)
*/
/*
スプリンブートエラーページの処理における優先順位
1．ビューテンプレット
resources/templates/error/500.html
resources/templates/error/5xx.html
2.情的リソース
resources/
*/
	@GetMapping("error-ex")
	public void errorEx() {
		throw new RuntimeException("エラー発生");
	}
	@GetMapping("error-404")
	public void error404(HttpServletResponse response)throws IOException{
		response.sendError(404, "404 エラー発生");
		}
		@GetMapping("error-500")
	public void error500(HttpServletResponse response)throws IOException{
		response.sendError(500, "500 エラー発生");
}
}
