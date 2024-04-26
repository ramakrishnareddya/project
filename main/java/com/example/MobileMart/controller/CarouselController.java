package com.example.MobileMart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.MobileMart.models.Carousel;
import com.example.MobileMart.service.CarouselRepository;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselRepository repo;
	
	@GetMapping({" ", "/"})
	public String  showCarouselList(Model model) {
		List<Carousel> carousel =repo.findAll();
		model.addAttribute("carousel", carousel);
		return "carousel/index";
	}

}

	