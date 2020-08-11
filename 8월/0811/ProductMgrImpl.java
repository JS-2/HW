package hw.product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrImpl implements IProductMgr {
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void insert(Product product) {
		products.add(product);
	}
	public ArrayList<Product> searchAll() {
		return products;
	}
	public Product searchWithNumber(int number) {
		Iterator<Product> iter = products.iterator();
		Product product;
		while(iter.hasNext()) {
			product = iter.next();
			if(product.getNumber() == number) {
				return product;
			}
		}
		return null;
	}
	public Product searchWithName(String name) {
		Iterator<Product> iter = products.iterator();
		Product product;
		while(iter.hasNext()) {
			product = iter.next();
			if(product.getName() == name) {
				return product;
			}
		}
		return null;
	}
	public ArrayList<TV> searchTV() {
		ArrayList<TV> tvs = new ArrayList<TV>();
		Iterator<Product> iter = products.iterator();
		Product temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof TV)
				tvs.add((TV)temp);
		}
		
		return tvs;
	}
	public ArrayList<Refrigerator> searchRef() {
		ArrayList<Refrigerator> refs = new ArrayList<Refrigerator>();
		Iterator<Product> iter = products.iterator();
		Product temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof Refrigerator)
				refs.add((Refrigerator)temp);
		}
		
		return refs;
	}
	public void deleteWithNumber(int number) {
		Iterator<Product> iter = products.iterator();
		Product product;
		while(iter.hasNext()) {
			product = iter.next();
			if(product.getNumber() == number)
				iter.remove();
		}
	}
	public int sumOfProducts() {
		Iterator<Product> iter = products.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			sum += iter.next().getPrice();
		}
		return sum;
	}
}
