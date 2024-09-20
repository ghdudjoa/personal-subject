package subject1;

import java.sql.Timestamp;

public class Bus {
	private String name;
	private String busNum;
	private Timestamp time;
	
	Bus(){}
	
	Bus(String name, String busNum){
		this.name = name;
		this.busNum = busNum;
	}
	
	Bus(String name, String busNum, Timestamp time){
		this.name = name;
		this.busNum =busNum;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusNum() {
		return busNum;
	}

	public void setBusNum(String busNum) {
		this.busNum = busNum;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Bus [name=" + name + ", busNum=" + busNum + ", time=" + time + "]";
	}
	
	
}
