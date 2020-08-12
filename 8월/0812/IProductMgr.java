package hw.product;

import java.util.ArrayList;

public interface IProductMgr {
	
	public void insert(Product product) throws DuplicateException;
	public ArrayList<Product> searchAll();
	public Product searchWithNumber(int number) throws CodeNotFoundException;
	public Product searchWithName(String name);
	public ArrayList<TV> searchTV() throws ProductNotFoundException;
	public ArrayList<Refrigerator> searchRef() throws ProductNotFoundException;
	public void deleteWithNumber(int number);
	public int sumOfProducts();
}

