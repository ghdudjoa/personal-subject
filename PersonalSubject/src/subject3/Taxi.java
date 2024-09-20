package subject3;

public class Taxi {
	String name;
	int taxiNum;
	String type;
	
	Taxi() {}
	
	public Taxi(String name, int taxiNum, String type) {
		super();
		this.name = name;
		this.taxiNum = taxiNum;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTaxiNum() {
		return taxiNum;
	}

	public void setTaxiNum(int taxiNum) {
		this.taxiNum = taxiNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "taxi [name=" + name + ", taxiNum=" + taxiNum + ", type=" + type + "]";
	}
	
	
}
