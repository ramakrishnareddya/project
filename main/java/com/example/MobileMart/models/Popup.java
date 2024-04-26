package com.example.MobileMart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="popup")
public class Popup {
	
	@Id
	private int id;
	public Popup(int id, String heading, String image, String description) {
		super();
		this.id = id;
		this.heading = heading;
		this.image = image;
		this.description = description;
	}
	private String heading;
	private String image;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Popup(int id, String heading, String image) {
		super();
		this.id = id;
		this.heading = heading;
		this.image = image;
	}
	public Popup() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Popup [id=" + id + ", heading=" + heading + ", image=" + image + ", description=" + description + "]";
	}
	
	

}
