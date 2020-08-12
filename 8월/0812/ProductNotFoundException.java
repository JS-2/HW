package hw.product;

public class ProductNotFoundException extends Exception {
	ProductNotFoundException() {
		super("상품이 존재하지 않습니다.");
	}
}
