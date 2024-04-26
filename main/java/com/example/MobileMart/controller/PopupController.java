package com.example.MobileMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MobileMart.models.Popup;
import com.example.MobileMart.service.PopupRepository;

@Controller
@RequestMapping("/popup")
public class PopupController {

	@Autowired
	private PopupRepository repo;


	@GetMapping({"","/"})
	public String showPopup(Model model) {
		List<Popup> popup = repo.findAll();
		model.addAttribute("popup", popup);
		return "popup/index";
	}
		
}
