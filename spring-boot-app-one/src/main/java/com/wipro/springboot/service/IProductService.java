package com.wipro.springboot.service;

import java.util.List;
import java.util.Optional;

import com.wipro.springboot.entity.Product;

public interface IProductService {

	Product saveProduct(Product product);

	Product getProduct(Integer id);

	List<Product> getAllProducts();

	List<Product> getAllByType(Optional<String> type);

	List<Product> getAllByQty(Optional<Integer> qty);

}
