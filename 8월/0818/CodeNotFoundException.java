package hw.product;

public class CodeNotFoundException extends Exception {
	CodeNotFoundException() {
		super("상품 번호가 존재하지 않습니다.");
	}
}
