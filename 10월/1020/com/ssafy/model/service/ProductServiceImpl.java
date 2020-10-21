package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

public class ProductServiceImpl implements ProductService {
	ProductRepo repo;
	public void setRepo(ProductRepo repo) {
		this.repo = repo;
	}

	@Override
	public ProductRepo getRepo() {
		System.out.println("getRepo() 호출");
		System.out.println(repo);
		return null;
	}

	@Override
	public int insert(Product product) {
		System.out.println("insert() 호출");
		System.out.println(product);
		return 0;
	}

	@Override
	public int update(Product product) {
		System.out.println("update() 호출");
		System.out.println(product);
		return 0;
	}

	@Override
	public int delete(String id) {
		System.out.println("delete() 호출");
		System.out.println(id);
		return 0;
	}

	@Override
	public Product select(String id) {
		System.out.println("select() 호출");
		System.out.println(id);
		return null;
	}

	@Override
	public List<Product> selectAll() {
		System.out.println("selectAll() 호출");
		return null;
	}

}
