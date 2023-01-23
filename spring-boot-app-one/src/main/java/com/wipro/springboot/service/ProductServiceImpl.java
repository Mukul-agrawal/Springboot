package com.wipro.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.entity.Product;
import com.wipro.springboot.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllByType(Optional<String> type) {
		return productRepository.findAllByType(type);
	}

	@Override
	public List<Product> getAllByQty(Optional<Integer> qty) {
		return productRepository.findAllByQty(qty);
	}

}
