package com.ssafy.product.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.ProductDAO;
import com.ssafy.product.dto.Product;

//컴포넌트 등록
@Service
public class ProductServiceImpl implements ProductService {

	//사용할 객체에 대한 주입
	@Autowired
	private ProductDAO dao;
	
	@Override
	public void regist(Product product) throws SQLException {
		dao.insert(product);
	}

	@Override
	public void modify(Product product) throws SQLException {
		dao.update(product);
	}

	@Override
	public void remove(String id) throws SQLException {
		dao.delete(id);
	}

	@Override
	public Product search(String id) throws SQLException {
		return dao.select(id);
	}

	@Override
	public List<Product> searchAll() throws SQLException {
		return dao.selectAll();
	}

}
