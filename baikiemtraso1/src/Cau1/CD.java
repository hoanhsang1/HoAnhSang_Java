package Cau1;
import java.util.Scanner;
import Cau1.process;
public class CD {
	process xl = new process();
	int MaCD;
	String tuaCD;
	String CaSy;
	int SoBaiHat;
	float GiaThanh;
	
	public void taoCD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tựa CD:");
		this.tuaCD = sc.nextLine();
		System.out.println("Nhập tên ca sĩ:");
		this.CaSy = sc.nextLine();
		System.out.println("Nhập số bài hát của CD:");
		this.SoBaiHat = xl.inputINT();
		System.out.println("Nhập số tiền của CD:");
		this.GiaThanh = xl.inputINT(); 
	}
	
	public void xuatCD() {
		System.out.println("Mã CD là:\t\t\t" + this.MaCD);
		System.out.println("Tựa CD là:\t\t\t" + this.tuaCD);
		System.out.println("Ca Sỹ là:\t\t\t" + this.CaSy);
		System.out.println("Tổng số bài hát:\t\t" + this.SoBaiHat);
		System.out.println("Giá cả:\t\t\t\t" + this.GiaThanh);
	}
}



