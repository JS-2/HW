

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productManage
 */
@WebServlet("/productManage.do")
public class productManage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("product_name");
		String price = request.getParameter("product_price");
		String info = request.getParameter("product_info");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div>상 품 명: "+ name + "</div>" +
				"<div>상품 가격: "+ price + "</div>" +
				"<div>상품 설명: "+ info + "</div>" +
				
				"</body>\r\n" + 
				"</html>");
	}

}
