package com.wipro.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.springboot.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByType(Optional<String> type);

	List<Product> findAllByQty(Optional<Integer> qty);

}
