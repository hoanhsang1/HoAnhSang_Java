package bai1;

public class PartTimeEmployee extends Employee{
	protected double SoGioLam;
	protected double DonGiaGio;
	
	
	//constructor
	public PartTimeEmployee() {super();};
	
	public PartTimeEmployee(double SoGioLam, double DonGiaGio, String MaNV, double HeSoLuong, String name, int age) {
		super(MaNV,HeSoLuong,name,age);
		this.SoGioLam = SoGioLam;
		this.DonGiaGio = DonGiaGio;
	}
	
	//get
	public double getSoGioLam() {return this.SoGioLam;};
	public double getDonGiaGio() {return this.DonGiaGio;};
	
	//set 
	public void setSoGioLam(double SoGioLam) {this.SoGioLam=SoGioLam;};
	public void setDonGiaGio(double DonGiaGio) {this.DonGiaGio = DonGiaGio;};
	
	@Override
    public double TinhLuong() {
        return SoGioLam * DonGiaGio * HeSoLuong;
    }
    
	@Override
	public String toString() {
	    return String.format("PART|%s|%s|%d|%.2f|%.2f|%.2f|%.2f", 
	        MaNV, Name, Age, TinhLuong(), HeSoLuong, SoGioLam, DonGiaGio);
	}
}
