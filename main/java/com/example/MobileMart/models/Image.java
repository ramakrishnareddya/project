package com.example.MobileMart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imageFileName;
	private String imageFileName1;
	private String imageFileName2;
	private String imageFileName3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageFileName1() {
		return imageFileName1;
	}
	public void setImageFileName1(String imageFileName1) {
		this.imageFileName1 = imageFileName1;
	}
	public String getImageFileName2() {
		return imageFileName2;
	}
	public void setImageFileName2(String imageFileName2) {
		this.imageFileName2 = imageFileName2;
	}
	public String getImageFileName3() {
		return imageFileName3;
	}
	public void setImageFileName3(String imageFileName3) {
		this.imageFileName3 = imageFileName3;
	}
	public Image(int id, String imageFileName, String imageFileName1, String imageFileName2, String imageFileName3) {
		super();
		this.id = id;
		this.imageFileName = imageFileName;
		this.imageFileName1 = imageFileName1;
		this.imageFileName2 = imageFileName2;
		this.imageFileName3 = imageFileName3;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", imageFileName=" + imageFileName + ", imageFileName1=" + imageFileName1
				+ ", imageFileName2=" + imageFileName2 + ", imageFileName3=" + imageFileName3 + "]";
	}
	
	
}
