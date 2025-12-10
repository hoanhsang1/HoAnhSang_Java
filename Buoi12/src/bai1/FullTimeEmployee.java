package bai1;

public class FullTimeEmployee extends Employee{
	protected double LuongCoBan;
	
	
	//constructor
	public FullTimeEmployee() {super();};
	
	public FullTimeEmployee(double LuongCoBan, String MaNV, double HeSoLuong, String name, int age) {
		super(MaNV,HeSoLuong,name,age);
		this.LuongCoBan = LuongCoBan;
	}
	
	//get
	public double getLuongCoBan() {return this.LuongCoBan;};
	
	//set 
	public void setLuongCoBan(double LuongCoBan) {this.LuongCoBan = LuongCoBan;};
	
	// Override phương thức tính lương
    @Override
    public double TinhLuong() {
        return LuongCoBan * HeSoLuong;
    }
    
    @Override
    public String toString() {
        return String.format("FULL|%s|%s|%d|%.2f|%.2f|%.2f", 
            MaNV, Name, Age, TinhLuong(), HeSoLuong, LuongCoBan);
    }
}
