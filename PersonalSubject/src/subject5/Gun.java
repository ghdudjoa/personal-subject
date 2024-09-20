package subject5;

public class Gun {
	private String name;
	private int price;
	private String function;
	private int gunNum;
	
	Gun(){}

	public Gun(String name, int price, String function, int gunNum) {
		super();
		this.name = name;
		this.price = price;
		this.function = function;
		this.gunNum = gunNum;
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

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	public int getGunNum() {
		return gunNum;
	}
	
	public void setGunNum(int gunNum) {
		this.gunNum = gunNum;
	}

	@Override
	public String toString() {
		return "Gun [name=" + name + ", price=" + price + ", function=" + function + ", gunNum=" + gunNum + "]";
	}		
	
}
