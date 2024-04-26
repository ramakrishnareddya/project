package com.example.MobileMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MobileMart.models.Navbar;
import com.example.MobileMart.models.NavigationBar;
import com.example.MobileMart.service.NavbarRepository;
import com.example.MobileMart.service.NavigationBarRepository;

@Controller
@RequestMapping("/navigationbar")
public class NavigationBarController {

	@Autowired
	private NavigationBarRepository repo;
	
	@Autowired
	private NavbarRepository navrepo;
		
	
	@GetMapping({"","/"})
	public String showNavigation(Model model) {
		List<NavigationBar> navigationbar = repo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		return "navigationbar/index";
	}
	
	@GetMapping("/navigation")
	public String showNavigationbar(Model model) {
		List<NavigationBar> navigationbar = repo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar =navrepo.findAll();
		model.addAttribute("navbar",navbar);
		return "navigationbar/navigation";
	}
	

}
