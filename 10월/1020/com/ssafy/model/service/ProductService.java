package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

public interface ProductService {
	public ProductRepo getRepo();
	public int insert(Product product);
	public int update(Product product);
	public int delete(String id);
	public Product select(String id);
	public List<Product> selectAll();
}
