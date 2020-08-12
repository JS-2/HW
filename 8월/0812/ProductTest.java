package hw.product;

import java.util.ArrayList;

public class ProductTest {
	
	public static void main(String[] args) {
		ProductMgrImpl mgr = new ProductMgrImpl();
		// insert Exception test
		

		// searchTV Exception test
		try {
		ArrayList<TV> tvArr = mgr.searchTV();
		for(TV tv: tvArr)
			System.out.println(tv);
		} catch(Exception e) { System.out.println(e.getMessage()); }
		
		
		// searchRef Exception test
		try {
			ArrayList<Refrigerator> refArr = mgr.searchRef();
			for(Refrigerator ref: refArr)
				System.out.println(ref);
		} catch(Exception e) { System.out.println(e.getMessage()); }
		
		try {
			mgr.insert(new TV(1111, "K1111", 1111, 1, 11, "QLED"));
			mgr.insert(new TV(2222, "K2222", 2222, 2, 22, "LED"));
			mgr.insert(new Refrigerator(3333,"R3333", 3333, 3, 333));
			mgr.insert(new Refrigerator(4444,"R4444", 4444, 4, 444));
			mgr.insert(new TV(5555, "K5555", 5555, 5, 55, "TN"));
			mgr.insert(new Refrigerator(6666,"6666", 6666, 6, 666));
			mgr.insert(new Refrigerator(6666,"6666", 6666, 6, 666));
		} catch(Exception e) { System.out.println(e.getMessage()); }
		
		
		// searchAll test
		ArrayList<Product> arr = mgr.searchAll();
		
		for(Product product: arr) 
			System.out.println(product);
		
		
		// searchWithNumber Exception test
		try {
			System.out.println(mgr.searchWithNumber(1234));
		} catch(Exception e) { System.out.println(e.getMessage()); }
		// searchWithName test
		System.out.println(mgr.searchWithName("R3333"));
		
		
		// deleteWithNumber test
		mgr.deleteWithNumber(3333);
		arr = mgr.searchAll();
		
		for(Product product: arr) 
			System.out.println(product);
		
		// sumOfProducts test
		System.out.println(mgr.sumOfProducts());
	}

}
