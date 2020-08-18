package hw.product;

public class DuplicateException extends Exception {
	DuplicateException() {
		super("이미 존재하는 상품입니다.");
	}
}
