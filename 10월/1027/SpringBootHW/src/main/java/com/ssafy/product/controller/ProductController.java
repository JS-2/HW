package com.ssafy.product.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.product.dto.Product;
import com.ssafy.product.service.ProductService;

//컴포넌트 등록
@Controller
public class ProductController {
   
	//서비스클래스에 대한 선언과 주입
	@Autowired
	private ProductService service;
	
	//URL요청에 매핑되는 메소드를 정의
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String registForm() {
	  return "form";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(Product product,Model model) {
		try {
			service.regist(product);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "입력 중 에러가 발생하였습니다(입력값을 확인)");
			return "error/error";  // WEB-INF/views/error/error.jsp
		}
		return "redirect:/list"; 
		               //return은 이동과 관련있음!!
		               //이동의 방법               : 1) forward               2) redirect
		               //스프링에서 표현법            return "list"             return "redirect:/list"    
		               //                   ==> list.jsp페이지표현             ==> 정의된 mapping "/list" 찾기   
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		try {
//			model.addAttribute(service.searchAll()); //키값이 생략!!  searchAll의 리턴타입: List
			                                          //List에서 첫글자 소문자로 변환한 값이 키값으로 적용 ==> "list"
			model.addAttribute("list", service.searchAll()); 
		} catch (SQLException e) {
			e.printStackTrace();
			return "error/error";  // WEB-INF/views/error/error.jsp
		}
		return "list";
	}
	
	@RequestMapping(value = "/read", method=RequestMethod.GET)
	public String read(String id,Model model) {
		try {
			model.addAttribute("product",service.search(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "read";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public String modifyForm(String id, Model model) {
		try {
			model.addAttribute("product",service.search(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "upform";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modify(Product product) {
		try {
			service.modify(product);//수정요청
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/list";
		//==> @RequestMapping(value = "/list") 정의된 메소드를 찾는다!!
		
		/*
		 만약
		@RequestMapping("/product")
		 class ProductController{
		    
		    @RequestMapping(value = "/list")
		    public String list(){}
		 }
		 
		 이렇게 정의되어 있다면
		 리턴값은 return "redirect:/product/list";
		 */
	}
	
	@RequestMapping(value = "/remove", method=RequestMethod.GET)
	public String remove(String id) {
		try {
			service.remove(id);//삭제요청
		} catch (SQLException e) {
			e.printStackTrace();
			return "error/error";
		}
		return "redirect:/list";
	}
	
}




