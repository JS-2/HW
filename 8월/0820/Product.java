
public class Product {
	private String isbn;
	private String name;
	private int price;
	private int quantity;
	
	public Product(String isbn, String name, int price, int quantity) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [isbn=" + isbn + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
