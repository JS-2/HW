package com.ssafy.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.dto.Product;

@Controller
public class MainController {
	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@RequestMapping("/list")
	public String showListPage(HttpServletRequest req) {
		Product product1 = new Product("A1234", "파워맥", 10000, "애플 컴퓨터");
		Product product2 = new Product("A1235", "아이맥", 20000, "애플 일체형 컴퓨터");
		ArrayList<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		req.setAttribute("products", products);
		return "list";
	}
}
