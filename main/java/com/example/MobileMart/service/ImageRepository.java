package com.example.MobileMart.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MobileMart.models.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
