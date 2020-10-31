package com.ssafy.product.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductDAO {
  //추가,수정,삭제,조회에 대한 명세
	public void insert(Product product)throws SQLException;
	public void update(Product product)throws SQLException;
	public void delete(String id)throws SQLException;

	public Product select(String id)throws SQLException;
	public List<Product> selectAll()throws SQLException;
}
