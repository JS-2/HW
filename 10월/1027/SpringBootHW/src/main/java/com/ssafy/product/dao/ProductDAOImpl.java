package com.ssafy.product.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.product.dto.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	//추가,수정,삭제,조회에 대한 구현
	
	@Autowired
	SqlSession sqlSession; //Mybatis sql태그를 읽어오기 위한 객체
	
	@Override
	public void insert(Product product) throws SQLException {
//		sqlSession.insert(statement);
//		sqlSession.insert(String statement, Object parameter)
//		sqlSession.insert("네임스페이스명.아이디명", 전달객체)
		sqlSession.insert("product.insert", product);
	}

	@Override
	public void update(Product product) throws SQLException {
		sqlSession.update("product.update",product);
	}

	@Override
	public void delete(String id) throws SQLException {
		sqlSession.delete("product.delete",id);
	}

	@Override
	public Product select(String id) throws SQLException {
		return sqlSession.selectOne("product.select", id);
		//select명령문 실행결과가 최대 한행이 나올때 selectOne()사용 >>> 예) where pk조건
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		return sqlSession.selectList("product.selectAll");
		//select명령문 실행결과가 2개 이상의 행이 예상될때 selectList()사용 
	}

}
