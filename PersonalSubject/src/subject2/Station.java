package subject2;

public class Station {
	
	private String name;
	private String stNum;
	private String address;
	
	Station(){}
	
	public Station(String name, String stNum, String address) {
		super();
		this.name = name;
		this.stNum = stNum;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Station [name=" + name + ", stNum=" + stNum + ", address=" + address + "]";
	}
	
	
}
