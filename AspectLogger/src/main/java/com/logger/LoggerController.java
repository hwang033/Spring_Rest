package com.logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class LoggerController {

	
	@RequestMapping("/return/{hello}")
	@Printable
	public @ResponseBody ResponseEntity<String> showInput(@PathVariable String hello){
		
		HttpHeaders res = new HttpHeaders(); 
		res.set("Access-Control-Allow-Origin", "*");
		res.set("Content-Type", "application/json");
		if(hello.equals("exception")){
			System.out.println("exception");
		}
		System.out.println(hello);
		return new ResponseEntity<String>(hello, res,  HttpStatus.OK);
	}
}
