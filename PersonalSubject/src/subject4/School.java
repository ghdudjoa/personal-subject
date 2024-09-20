package subject4;

public class School {
	
	private String name;
	private int classNum;
	private double grade;
	private int studentNum;
	
	public School() {}
	
	public School(String name, int classNum, double grade, int studentNum) {
		super();
		this.name = name;
		this.classNum = classNum;
		this.grade = grade;
		this.studentNum = studentNum;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", classNum=" + classNum + ", grade=" + grade + ", studentNum="
				+ studentNum + "]";
	}
	
	
}
