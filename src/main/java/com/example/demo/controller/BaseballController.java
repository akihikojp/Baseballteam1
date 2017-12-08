package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.BaseballTeam;
import com.example.demo.repository.BaseballRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("")
public class BaseballController {
	
	/**JSONとJavaオブジェクトの相互変換ができるクラス*/
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	BaseballRepository baseballRepository;
	
	@RequestMapping("/top")
	public String top() {
		return "top";
	}
	
	@ResponseBody
	@RequestMapping("/index")
	public List<BaseballTeam> findAll() {
		return baseballRepository.findAll();
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,Integer id) {
		model.addAttribute("team", baseballRepository.findById(id));
		return "detail";
	}
	
	
	
	@PostMapping(value = "/register_baseballteam")
	public void registerNewTeam(String ajaxData)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("aaaaaaaaaaaaaa" + ajaxData);
	BaseballTeam ajaxBaseballTeam 
	= mapper.readValue(ajaxData, BaseballTeam.class);
	
	baseballRepository.save(ajaxBaseballTeam);
	
//	return "top";
	}
	

}
