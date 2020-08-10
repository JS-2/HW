package com.ssafy;

public class ProductTest {
	
	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		// insert test
		mgr.insert(new TV(1111, "K1111", 1111, 1, 11, "QLED"));
		mgr.insert(new TV(2222, "K2222", 2222, 2, 22, "LED"));
		mgr.insert(new Refrigerator(3333,"R3333", 3333, 3, "333L"));
		mgr.insert(new Refrigerator(4444,"R4444", 4444, 4, "444L"));
		mgr.insert(new TV(5555, "K5555", 5555, 5, 55, "TN"));
		mgr.insert(new Refrigerator(6666,"6666", 6666, 6, "666L"));
		
		// searchAll test
		Product[] arr = mgr.searchAll();
		
		for(Product product: arr) 
			System.out.println(product);
		
		
		// searchWithNumber test
		System.out.println(mgr.searchWithNumber(3333));
		
		// searchWithName test
		System.out.println(mgr.searchWithName("R3333"));
		
		// searchTV test
		TV[] tvArr = mgr.searchTV();
		
		for(TV tv: tvArr)
			System.out.println(tv);
		
		// searchRef test
		Refrigerator[] refArr = mgr.searchRef();
		
		for(Refrigerator ref: refArr)
			System.out.println(ref);
		
		// deleteWithNumber test
		mgr.deleteWithNumber(3333);
		arr = mgr.searchAll();
		
		for(Product product: arr) 
			System.out.println(product);
		
		// sumOfProducts test
		System.out.println(mgr.sumOfProducts());
	}

}
