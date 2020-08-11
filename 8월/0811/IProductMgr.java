package hw.product;

import java.util.ArrayList;

public interface IProductMgr {
	
	public void insert(Product product);
	public ArrayList<Product> searchAll();
	public Product searchWithNumber(int number);
	public Product searchWithName(String name);
	public ArrayList<TV> searchTV();
	public ArrayList<Refrigerator> searchRef();
	public void deleteWithNumber(int number);
	public int sumOfProducts();
}

