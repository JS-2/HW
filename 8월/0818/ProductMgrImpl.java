package hw.product;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
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
			if(temp instanceof TV)
				tvs.add((TV)temp);
		}
		if(tvs.size() == 0)
			throw new ProductNotFoundException();
		else
			return tvs;
	}
	public ArrayList<Refrigerator> searchRef() throws ProductNotFoundException {
		ArrayList<Refrigerator> refs = new ArrayList<Refrigerator>();
		Iterator<Product> iter = products.iterator();
		Product temp;
		while(iter.hasNext()) {
			temp = iter.next();
			if(temp instanceof Refrigerator)
				refs.add((Refrigerator)temp);
		}
		if(refs.size() == 0)
			throw new ProductNotFoundException();
		else
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
	
	public void saveDataFile() {
		new Thread() {
			@Override
			public void run() {
				FileOutputStream fileOut = null;
				ObjectOutputStream objOut = null;
				synchronized(products) {
					try {
						fileOut = new FileOutputStream("product.dat");
						objOut = new ObjectOutputStream(fileOut);
						objOut.writeObject(products);
					} catch (Exception e) {
								e.printStackTrace();
					} finally {
						if(objOut != null) {
							try {
								objOut.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else if (fileOut != null) {
							try {
								fileOut.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}.start();
	}
	
	public void readDataFile() {
		
		new Thread() {
			@Override
			public void run() {
				ObjectInputStream objInputStream = null;
				FileInputStream inputStream = null;
				synchronized(products) {
					try {
						inputStream = new FileInputStream("product.dat");
						objInputStream = new ObjectInputStream(inputStream);
						
						ArrayList<Product> read = (ArrayList<Product>) objInputStream.readObject();
						Iterator<Product> iter = read.iterator();
						while(iter.hasNext())
							System.out.println(iter.next());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public void sendData() {
		new Thread() {
			@Override
			public void run() {
				String host = "localhost";
				int port = 5100;
				
				try(Socket socket = new Socket(host, port)) {
					OutputStream output = socket.getOutputStream();
					ObjectOutputStream objOutput = new ObjectOutputStream(output);
					objOutput.writeObject(searchTV());
					objOutput.writeObject(searchRef());
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
}
