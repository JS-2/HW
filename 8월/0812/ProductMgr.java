package hw.product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductMgr {
	private LinkedList<Product> products = new LinkedList<Product>();
	private int tvCnt;
	private int refCnt;
	
	ProductMgr() { 
		tvCnt = 0;
		refCnt = 0;
	}
	
	public void insert(Product product) {
		products.add(product);
		
		if(product instanceof TV)
			tvCnt++;
		else
			refCnt++;
	}
	
	public Product[] searchAll() {
		Iterator<Product> iter = products.iterator();
		Product[] products = new Product[this.tvCnt + this.refCnt] ;
		
		for(int i = 0; i < this.tvCnt + this.refCnt; i++) 
			products[i] = iter.next();
		
		return products;
	}
	
	public Product searchWithNumber(int number) {
		Iterator<Product> iter = products.iterator();
		Product product = null, temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp.getNumber() == number) { 
				product = temp;
				break;
			}
		}
		return product;
	}
	
	public Product searchWithName(String name) {
		Iterator<Product> iter = products.iterator();
		Product product = null, temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp.getName() == name) { 
				product = temp;
				break;
			}
		}
		return product;
	}
	
	public TV[] searchTV() {
		Iterator<Product> iter = products.iterator();
		TV[] tvs = new TV[tvCnt];
		Product temp;
		int cnt = 0;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof TV) 
				tvs[cnt++] = (TV)temp;
		}
		
		return tvs;
	}
	
	public Refrigerator[] searchRef() {
		Iterator<Product> iter = products.iterator();
		Refrigerator[] refs = new Refrigerator[refCnt];
		Product temp;
		int cnt = 0;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof Refrigerator) 
				refs[cnt++] = (Refrigerator)temp;
		}
		
		return refs;
	}
	
	public void deleteWithNumber(int number) {
		if(this.tvCnt + this.refCnt == 0)
			return;
		
		Iterator<Product> iter = products.iterator();
		Product temp = null;
		int cnt = 0;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp.getNumber() == number)
				break;
			++cnt;
		}
		
		if(cnt != this.refCnt + this.tvCnt) {
			if(temp instanceof TV)
				--tvCnt;
			else
				--refCnt;
			products.remove(cnt);
		}
	}
	
	public int sumOfProducts() {
		int sum = 0;
		Iterator<Product> iter = products.iterator();
		
		while(iter.hasNext()) 
			sum += iter.next().getPrice();
		
		return sum;
	}
}
