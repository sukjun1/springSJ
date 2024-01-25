package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.DealDTO;
import com.example.demo.entity.Deal;
import com.example.demo.service.DealService;


@Controller
@RequestMapping("/deal")

public class DealController {
	@Autowired
	DealService service;
	
	@GetMapping("/main")
	public void main(Model model) {
		List<DealDTO> list = service.getList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	@PostMapping("/register")
	public String registerPost(DealDTO dto, RedirectAttributes redirectAttributes) {
		int no = service.register(dto);
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/deal/main";
	}
	@GetMapping("/read")
	public void read(@RequestParam(name="no")int no,Model model) {
		DealDTO dto = service.read(no);
		model.addAttribute("dto",dto);
	}
	@GetMapping("/modify")
	public void modify(@RequestParam(name="no")int no,Model model) {
		DealDTO dto = service.read(no);
		model.addAttribute("dto",dto);
	}
	@PostMapping("/modify")
	public String modifyPost(DealDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("no",dto.getNo());
		return "redirect:/deal/read";
	}
	@PostMapping("/remove")
	public String removePost(@RequestParam(name="no")int no) {
		service.remove(no);
		return "redirect:/deal/main";
	}
	@GetMapping("/mainSearch")
	public void mainSearch(@RequestParam(name="title")String title,Model model) {
		List<Deal> searchList = service.search(title);
		model.addAttribute("searchList", searchList);
		
	}
}
