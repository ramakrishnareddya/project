package com.example.MobileMart.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;

public class ImageDto {
	
	@NotNull(message="This Field is Required")
	private MultipartFile imageFileName;
	
	@NotNull(message="This Field is Required")
	private MultipartFile imageFileName1;
	
	@NotNull(message="This Field is Required")
	private MultipartFile imageFileName2;
	
	@NotNull(message="This Field is Required")
	private MultipartFile imageFileName3;

	public MultipartFile getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(MultipartFile imageFileName) {
		this.imageFileName = imageFileName;
	}

	public MultipartFile getImageFileName1() {
		return imageFileName1;
	}

	public void setImageFileName1(MultipartFile imageFileName1) {
		this.imageFileName1 = imageFileName1;
	}

	public MultipartFile getImageFileName2() {
		return imageFileName2;
	}

	public void setImageFileName2(MultipartFile imageFileName2) {
		this.imageFileName2 = imageFileName2;
	}

	public MultipartFile getImageFileName3() {
		return imageFileName3;
	}

	public void setImageFileName3(MultipartFile imageFileName3) {
		this.imageFileName3 = imageFileName3;
	}


	

}
