package com.example.MobileMart.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MobileMart.models.Product;


public 	interface  ProductRepository extends JpaRepository<Product, Integer> {


}
