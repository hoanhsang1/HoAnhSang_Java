package vidutailieu;

import java.util.Scanner;

public class xeGa extends xeMay{
	private String nhaSX, model;
	public xeGa( ) {
		super();
	}
	public xeGa(String s_nhasx, String s_model,double f_chiphisx)
	{ 
		super(f_chiphisx);
		this.nhaSX = s_nhasx;
		this.model = s_model;
		this.chiPhiSX = f_chiphisx;
	}
	
	// set/get
	public String getModal() {return this.model;};
	public String getNhaSX() {return this.nhaSX;};
	public double getChiPhi() {return this.chiPhiSX;};
	
	public void setModal(String s_model) {this.model=s_model;};
	public void setNhaSX(String s_nhasx) {this.nhaSX = s_nhasx;};
	public void setChiPhi(double f_chiphisx) {this.chiPhiSX=f_chiphisx;};
	
	public double tinhGiaBan( ) {
		return 2.5 * chiPhiSX;
	}
	
	public void xuat() {
		System.out.println("Hãng xe là: "+ nhaSX);
		System.out.println("Loại xe là: "+ model);

		super.xuat();
		System.out.println("Giá bán thực tế là: "+ tinhGiaBan());
	}
	
	Scanner sc = new Scanner(System.in);
	public void Nhap() {
		System.out.println("Nhập hảng xe:");
		nhaSX = sc.nextLine();
		System.out.println("Nhập loại xe:");
		model = sc.nextLine();
		super.Nhap();
	}
}
