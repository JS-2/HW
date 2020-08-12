package hw.product;

public class Refrigerator extends Product {
	private int volume;
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	Refrigerator(int number, String name, int price, int quantity, int volume) {
		super(number, name, price, quantity);
		this.volume = volume;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n용       량: " + volume;
	}
}
