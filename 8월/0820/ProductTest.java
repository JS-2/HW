import java.util.ArrayList;
import java.util.Iterator;

public class ProductTest {

	public static void main(String[] args) {
		ArrayList<Product> products;
		Iterator<Product> iter;
		Product product;
		
		ProductDao productDao = new ProductDao();
		
		System.out.println("************* 제품 검색: 라면 *************");
		products = productDao.searchWithName("라면");
		iter = products.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("************* 가격 검색: 1000 이하 *************");
		products = productDao.searchWithPrice(1000);
		iter = products.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("************* 제품번호 검색: 111111 *************");
		product = productDao.searchWithIsbn("111111");
		System.out.println(product);
		
		System.out.println("************* 제품번호로 삭제: 111111 *************");
		productDao.deleteWithIsbn("111111");
		
		System.out.println("************* 가격 업데이트  *************");
		productDao.updatePrice("222222", 900, 5000);
		
	}

}
