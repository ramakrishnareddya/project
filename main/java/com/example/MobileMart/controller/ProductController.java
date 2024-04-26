package com.example.MobileMart.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.MobileMart.models.Navbar;
import com.example.MobileMart.models.NavigationBar;
import com.example.MobileMart.models.Popup;
import com.example.MobileMart.models.Product;
import com.example.MobileMart.models.ProductDto;
import com.example.MobileMart.service.NavbarRepository;
import com.example.MobileMart.service.NavigationBarRepository;
import com.example.MobileMart.service.PopupRepository;
import com.example.MobileMart.service.ProductRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/product")


public class ProductController {

	@Autowired
		private ProductRepository repo;
	
	@Autowired
	private NavigationBarRepository navigationrepo;
	
	@Autowired
	private NavbarRepository navrepo;
	
	@Autowired
	private PopupRepository popuprepo;
		
	// To Display Table 
	
	@GetMapping({"","/"})
		public String showProductList(Model model) {
			List<Product> products = repo.findAll();
			model.addAttribute("product",products);
			return "product/index.html";
		}
	
	// To display Carousel
	
	
	@GetMapping({"/carousel"})
	public String showCarousel(Model model) {
		List<Product> product =repo.findAll();
		model.addAttribute("product", product);
		return "product/Carousel";
	}
	
	
	// To Display Cards
	
	@GetMapping({"/cards"})
	public String showCards(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		return "product/cards";
	}
	
	@GetMapping("/cardsslide")
	public String showCardsslide(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<Popup> popup = popuprepo.findAll();
		model.addAttribute("popup",popup);
		return "product/cardsslide";	
	}
	
	@GetMapping("/website")
	public String showCardsCarousel (Model model) {
		List<Product> product=repo.findAll(); 
		model.addAttribute("product", product); 
		
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		List<Popup> popup = popuprepo.findAll();
		model.addAttribute("popup",popup);
		
		return "product/website";
	}
	
	@GetMapping("/home")
	public String showhomecarousel(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		return "product/home";
	}
	
	@GetMapping("/about")
	public String showabout(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		return "product/about";
	}
	
	@GetMapping("/deals")
	public String showdeals(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		return "product/deals";
	}
	
	@GetMapping("/feedback")
	public String showfeedback(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		return "product/feedback";
	}
	
	@GetMapping("/login")
	public String showlogin(Model model) {
		List<Product> product = repo.findAll();
		model.addAttribute("product",product);
		List<NavigationBar> navigationbar = navigationrepo.findAll();
		model.addAttribute("navigationbar", navigationbar);
		
		List<Navbar> navbar = navrepo.findAll();
		model.addAttribute("navbar", navbar);
		
		return "product/login";
	}
	// Create Product
			
	@GetMapping("/create")
		public String showCreatePage(Model model) {
			ProductDto productDto = new ProductDto();
			model.addAttribute("productDto",productDto);
			return "product/CreateProduct";
		}
			
	@PostMapping("/create")
		public String createProuct(
			@Valid @ModelAttribute ProductDto productDto, BindingResult result) {
				
			if(productDto.getImageFile().isEmpty()) {
			result.addError(new FieldError("productDto","imageFile","the image file is required"));
			}
			if(result.hasErrors()) {
				return "product/CreateProduct";
			}
			
	//saving the Image File
				
	MultipartFile image = productDto.getImageFile();
		Date createdAt = new Date();
			String storageFileName = createdAt.getTime()+"_"+image.getOriginalFilename();
			
			try {
				String uploadDir = "public/images/";
				Path uploadPath = Paths.get(uploadDir);
				
				if(!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}
				
			try(InputStream inputStream = image.getInputStream()) {
					Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
							StandardCopyOption.REPLACE_EXISTING);
				}
			
			}catch(Exception ex) {
				System.out.println("Exception : " + ex.getMessage());
			}
			
			Product product = new Product();
			product.setName(productDto.getName());
			product.setBrand(productDto.getBrand());
			product.setCategory(productDto.getCategory());
			product.setPrice(productDto.getPrice());
			product.setDescription(productDto.getDescription());
			product.setCreatedAt(createdAt);
			product.setImageFileName(storageFileName);
				
			repo.save(product);
				
			return "redirect:/product";
		}
			
	@GetMapping("/edit")
		public String showEditPage(Model model, @RequestParam int id) {
				
		try {
			Product product = repo.findById(id).get();
			model.addAttribute("product",product);
					
			ProductDto productDto = new ProductDto();
			productDto.setName(product.getName());
			productDto.setBrand(product.getBrand());
			productDto.setCategory(product.getCategory());
			productDto.setPrice(product.getPrice());
			productDto.setDescription(product.getDescription());
					
			model.addAttribute("productDto",productDto);
			}
				
	catch(Exception ex) {
		System.out.println("Exception: " + ex.getMessage());
		return "redirect:/product";
		}
		return "product/EditProduct";
		}
					
	@PostMapping("/edit")
		public String updateProduct(Model model, @RequestParam int id,@Valid @ModelAttribute ProductDto productDto,BindingResult result) {
						
		try {
			Product product=repo.findById(id).get();
			model.addAttribute("product", product);
							
		if(result.hasErrors()) {
			return "product/EditProduct";
		}
							
		if(!productDto.getImageFile().isEmpty()) {
//for deleting the old image
			String uploadDir="public/images/";
			Path oldImagePath = Paths.get(uploadDir + product.getImageFileName());
								
			try {
				Files.delete(oldImagePath);
			}
								
			catch(Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
			}
//save the new image
								
			MultipartFile  image = productDto.getImageFile();
				Date createdAt = new Date();
				String storageFileName = createdAt.getTime()+"_"+image.getOriginalFilename();
								
			try(InputStream inputStream = image.getInputStream()){
				Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
				StandardCopyOption.REPLACE_EXISTING);
			}
				product.setImageFileName(storageFileName);
			}
			product.setName(productDto.getName());
			product.setBrand(productDto.getBrand());
			product.setCategory(productDto.getCategory());
			product.setPrice(productDto.getPrice());
			product.setDescription(productDto.getDescription());
								
			repo.save(product);
			}
						
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
			return "redirect:/product";
		}
					
	@GetMapping("/delete")
		public String deleteProduct(@RequestParam int id) {
						
		try {
			Product product = repo.findById(id).get();
			
			//For Deleting Image File
							
			Path imagePath = Paths.get("public/images/" + product.getImageFileName());
							
		try {
			Files.delete(imagePath);
		}
							
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
							
		//To delete the product
		repo.delete(product);
		}
						
						
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
			return "redirect:/product";
		}
	}
		
