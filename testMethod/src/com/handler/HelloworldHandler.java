package com.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

@Controller
public class HelloworldHandler {
	@RequestMapping(value="hello.do",method=RequestMethod.GET)
	public ModelAndView helloworld() {
		ModelAndView modelAndView = new ModelAndView("index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="testJson.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonObject testJson() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("result", "yes!");
		return jsonObject;
	}
}
