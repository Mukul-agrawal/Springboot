package com.wipro.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.entity.Product;
import com.wipro.springboot.service.IProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam Optional<String> type,
			@RequestParam Optional<Integer> qty) {
		if (type.isPresent()) {
			return new ResponseEntity<List<Product>>(productService.getAllByType(type), HttpStatus.OK);
		}
		if (qty.isPresent()) {
			return new ResponseEntity<List<Product>>(productService.getAllByQty(qty), HttpStatus.OK);
		}
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
		return new ResponseEntity<Product>(productService.getProduct(id), HttpStatus.OK);
	}

}
