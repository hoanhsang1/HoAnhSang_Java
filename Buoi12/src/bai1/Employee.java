package bai1;

public class Employee extends Person{
	protected String MaNV;
	protected double HeSoLuong;
	
	
	//constructor
	public Employee() {super();};
	
	public Employee(String MaNV, double HeSoLuong, String name, int age) {
		super(name,age);
		this.MaNV = MaNV;
		this.HeSoLuong = HeSoLuong;
	}
	
	//get
	public String getMaNV() {return this.MaNV;};
	public double getHeSoLuong() {return this.HeSoLuong;};
	
	//set 
	public void setMaNV(String MaNV) {this.MaNV=MaNV;};
	public void setHeSoLuong(double HeSoLuong) {this.HeSoLuong = HeSoLuong;};
	
	//tính lương
	public double TinhLuong() {
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%s|%s|%d|%2f", MaNV, Name, Age, TinhLuong());
	}
}
