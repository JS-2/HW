package com.ssafy.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;

@Repository
public class ProductRepoImpl implements ProductRepo {

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
