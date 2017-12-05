package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.BaseballTeam;
import com.example.demo.repository.BaseballRepository;

@Controller
@RequestMapping("")
public class BaseballController {
	
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

}
