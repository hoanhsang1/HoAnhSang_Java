package vidutailieu;

import java.util.Scanner;

public class xeMay {
	protected double chiPhiSX;
	
	public xeMay() {};
	
	public xeMay(double cfsx) {
		this.chiPhiSX = cfsx;
	}
	
	public double tinhGiaBan()
	{
	return 2 * this.chiPhiSX;
	}
	
	public void setChiPhi(double f_chiphisx) {this.chiPhiSX=f_chiphisx;};
	public double getChiPhi() {return this.chiPhiSX;};
	
	public void xuat() {
		System.out.println("Chi phí sản xuất là: "+ chiPhiSX);
	}
	
	Scanner sc = new Scanner(System.in);
	public void Nhap() {
		System.out.println("Nhập chi phí sản xuất:");
		chiPhiSX= sc.nextDouble();
	}
}
