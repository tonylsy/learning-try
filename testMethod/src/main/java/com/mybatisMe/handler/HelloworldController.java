package com.mybatisMe.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloworldController {
	
	
	
	@RequestMapping("getImgCode.do")
	public void getImgCode(HttpServletRequest req,HttpServletResponse response) throws IOException {
		
		try {
			response.setContentType("image/jpeg");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Controller", "no-cache");
			response.setHeader("Set-Cookie", "name=value;HttpOnly");
			response.setDateHeader("Expire", 0);
			response.getOutputStream().write(null);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
		
	}
}
