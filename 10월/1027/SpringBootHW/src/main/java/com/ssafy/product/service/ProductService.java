package com.ssafy.product.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductService {
	//추가,수정,삭제,조회,비즈니스 로직에 대한 명세
	//==> 사용자 관점에서 명명해주는 것이 좋다.
	
	public void regist(Product product)throws SQLException;
	public void modify(Product product)throws SQLException;
	public void remove(String id)throws SQLException;
	public Product search(String id)throws SQLException;
	public List<Product> searchAll()throws SQLException;

}
