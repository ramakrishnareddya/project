package com.example.MobileMart.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

import com.example.MobileMart.models.Image;
import com.example.MobileMart.models.ImageDto;
import com.example.MobileMart.service.ImageRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageRepository repo;
	
	@GetMapping({"", "/"})
	public String showImagesList(Model model) {
		List<Image> images=repo.findAll();
		model.addAttribute("images" , images);
		return "image/index";
	}
	
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		ImageDto imgDto = new ImageDto();
		model.addAttribute("imgDto",imgDto);
		return "image/CreateImage";
	}
	
	
	@PostMapping("/create")
	public String CreateImage(
			@Valid @ModelAttribute ImageDto imgDto,
			BindingResult result
			) {
		
		if(imgDto.getImageFileName().isEmpty()) {
			result.addError(new FieldError("imgDto","imageFileName","the image file is required"));
		}
		if(result.hasErrors()) {
			return "image/CreateImage";
}
	

//saving the imageFileName
		
		MultipartFile image = imgDto.getImageFileName();
		String storageFileName = image.getOriginalFilename();
		
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
		
		
		
		
		// Saving imageFileName 
		
		if(imgDto.getImageFileName1().isEmpty()) {
			result.addError(new FieldError("imgDto","imageFileName1","the image file is required"));
		}
		if(result.hasErrors()) {
			return "image/CreateImage";
}
		
	
		MultipartFile image1 = imgDto.getImageFileName1();
		String storageFileName1 = image1.getOriginalFilename();
		
		try {
		String uploadDir1 = "public/images/";
		Path uploadPath1 = Paths.get(uploadDir1);
		
		if(!Files.exists(uploadPath1)) {
			Files.createDirectories(uploadPath1);
		}
		
		try(InputStream inputStream1 = image.getInputStream()) {
			Files.copy(inputStream1, Paths.get(uploadDir1 + storageFileName),
					StandardCopyOption.REPLACE_EXISTING);
		}
	}catch(Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
	}
		
		if(imgDto.getImageFileName2().isEmpty()) {
			result.addError(new FieldError("imgDto","imageFileName2","the image file is required"));
		}
		if(result.hasErrors()) {
			return "image/CreateImage";
}
		
		
		MultipartFile image2 = imgDto.getImageFileName2();
		String storageFileName2 = image2.getOriginalFilename();
		
		try {
		String uploadDir2 = "public/images/";
		Path uploadPath2 = Paths.get(uploadDir2);
		
		if(!Files.exists(uploadPath2)) {
			Files.createDirectories(uploadPath2);
		}
		
		try(InputStream inputStream2 = image2.getInputStream()) {
			Files.copy(inputStream2, Paths.get(uploadDir2 + storageFileName),
					StandardCopyOption.REPLACE_EXISTING);
		}
	}catch(Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
	}
			
		// Saving imageFileName 2
		
		
		if(imgDto.getImageFileName3().isEmpty()) {
			result.addError(new FieldError("imgDto","imageFileName3","the image file is required"));
		}
		if(result.hasErrors()) {
			return "image/CreateImage";
}
		
		
		
		MultipartFile image3 = imgDto.getImageFileName3();
		String storageFileName3 = image3.getOriginalFilename();
		
		try {
		String uploadDir3 = "public/images/";
		Path uploadPath3 = Paths.get(uploadDir3);
		
		if(!Files.exists(uploadPath3)) {
			Files.createDirectories(uploadPath3);
		}
		
		try(InputStream inputStream3 = image.getInputStream()) {
			Files.copy(inputStream3, Paths.get(uploadDir3 + storageFileName),
					StandardCopyOption.REPLACE_EXISTING);
		}
	}catch(Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
	}
		
		
		Image img = new Image();
		img.setImageFileName(storageFileName);
		img.setImageFileName1(storageFileName1);
		img.setImageFileName2(storageFileName2);
		img.setImageFileName3(storageFileName3);
		
		repo.save(img);
		
		return "redirect:/images/";
}

	
	
	
	@GetMapping("/edit")

	public String ShowCarousel(Model model, @RequestParam int id) {
		try {
			Image img = repo.findById(id).get();
			model.addAttribute("img",img);	
			
		}catch(Exception e) {
			System.out.println(e);
		}	
		return "image/EditImage";
	}
	
	
	@PostMapping("/edit")
	public String editsamsung(@RequestParam int id,Model model, @Valid @ModelAttribute ImageDto imgDto,BindingResult result) {
		try {
			Image img = repo.findById(id).get();
			model.addAttribute("img", img);
			if(result.hasErrors()) {
				return "image/EditImage";
			}	
					
			
			if(!imgDto.getImageFileName().isEmpty()) {
				String uploadDir ="public/images";
				Path OldImage = Paths.get(uploadDir+img.getImageFileName());
				try {
					Files.delete(OldImage);
				}catch(Exception e) {
					System.out.println(e);
				}				
					MultipartFile image = imgDto.getImageFileName();
					String Storeimage = image.getOriginalFilename();
					
					try(InputStream inputStream = image.getInputStream()) {
					Files.copy(inputStream,Paths.get(uploadDir+Storeimage),StandardCopyOption.REPLACE_EXISTING);
				}
					img.setImageFileName(Storeimage);	
					
					repo.save(img);
			}
			
			
			
			if(!imgDto.getImageFileName1().isEmpty()) {
				String uploadDir ="public/images";
				Path OldImage = Paths.get(uploadDir+img.getImageFileName1());
				try {
					Files.delete(OldImage);
				}catch(Exception e) {
					System.out.println(e);
				}				
					MultipartFile image1 = imgDto.getImageFileName1();
					String Storeimage1 = image1.getOriginalFilename();
					
					try(InputStream inputStream1 = image1.getInputStream()) {
					Files.copy(inputStream1,Paths.get(uploadDir+Storeimage1),StandardCopyOption.REPLACE_EXISTING);
				}
					img.setImageFileName(Storeimage1);	
					
					repo.save(img);
			}

			
			if(!imgDto.getImageFileName2().isEmpty()) {
				String uploadDir ="public/images";
				Path OldImage = Paths.get(uploadDir+img.getImageFileName2());
				try {
					Files.delete(OldImage);
				}catch(Exception e) {
					System.out.println(e);
				}				
					MultipartFile image2 = imgDto.getImageFileName2();
					String Storeimage2 = image2.getOriginalFilename();
					
					try(InputStream inputStream2 = image2.getInputStream()) {
					Files.copy(inputStream2,Paths.get(uploadDir+Storeimage2),StandardCopyOption.REPLACE_EXISTING);
				}
					img.setImageFileName(Storeimage2);	
					
					repo.save(img);
			}

			
			if(!imgDto.getImageFileName3().isEmpty()) {
				String uploadDir ="public/images";
				Path OldImage = Paths.get(uploadDir+img.getImageFileName3());
				try {
					Files.delete(OldImage);
				}catch(Exception e) {
					System.out.println(e);
				}				
					MultipartFile image3 = imgDto.getImageFileName3();
					String Storeimage3 = image3.getOriginalFilename();
					
					try(InputStream inputStream3 = image3.getInputStream()) {
					Files.copy(inputStream3,Paths.get(uploadDir+Storeimage3),StandardCopyOption.REPLACE_EXISTING);
				}
					img.setImageFileName(Storeimage3);	
					
					repo.save(img);
			}
			

		}catch(Exception e) {
			System.out.println(e);
		}	
		return "redirect:/images/";
	}

	
			
			
	@GetMapping("/delete")

	public String deletesamsung(@RequestParam int id){

		try {

			Image img = repo.findById(id).get();
			Path image = Paths.get("public/images/"+img.getImageFileName());
			Path image1 =Paths.get("public/images/" + img.getImageFileName1());
			Path image2 = Paths.get("public/images/" + img.getImageFileName2());
			Path image3 = Paths.get("public/images/" + img.getImageFileName3());	

			try {

				Files.delete(image);
				Files.delete(image1);
				Files.delete(image2);
				Files.delete(image3);
			}catch(Exception e) {
				System.out.println(e);
			}

			repo.delete(img);
	

		}catch(Exception e) {

			System.out.println(e);

		}

		return "redirect:/images/";

	}


}
