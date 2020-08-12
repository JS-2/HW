package hw.product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrImpl implements IProductMgr {
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void insert(Product product) throws DuplicateException {
		Iterator<Product> iter = products.iterator();
		Product temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(product.getNumber() == temp.getNumber())
				throw new DuplicateException();
		}
		products.add(product);
	}
	public ArrayList<Product> searchAll() {
		return products;
	}
	public Product searchWithNumber(int number) throws CodeNotFoundException {
		Iterator<Product> iter = products.iterator();
		Product product;
		while(iter.hasNext()) {
			product = iter.next();
			if(product.getNumber() == number) {
				return product;
			}
		}
		throw new CodeNotFoundException();
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
	public ArrayList<TV> searchTV() throws ProductNotFoundException {
		ArrayList<TV> tvs = new ArrayList<TV>();
		Iterator<Product> iter = products.iterator();
		Product temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof TV && ((TV) temp).getSize() >= 50)
				tvs.add((TV)temp);
		}
		
		throw new ProductNotFoundException();
	}
	public ArrayList<Refrigerator> searchRef() throws ProductNotFoundException {
		ArrayList<Refrigerator> refs = new ArrayList<Refrigerator>();
		Iterator<Product> iter = products.iterator();
		Product temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof Refrigerator && ((Refrigerator) temp).getVolume() >= 400)
				refs.add((Refrigerator)temp);
		}
		
		throw new ProductNotFoundException();
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
