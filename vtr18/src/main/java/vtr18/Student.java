package vtr18;

public class Student {
	int id;
	String name;
	String address;
	int totalMarks;
	String usn;
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", usn=" + usn + ", name=" + name + ", address=" + address + ", totalMarks="
				+ totalMarks + "]";
	}
}
