package bai1;
import java.util.*;

public class sinhvien {
	Xuly xl = new Xuly();
	int MaSV;
	String hoten;
	String Ngaysinh;
	String gioitinh;
	float diemthi;
	String xeploai;
	
	
	public void taoSV() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập họ và tên sinh viên:");
		this.hoten = sc.nextLine();
		this.diemthi = xl.inputDiem();
		this.Ngaysinh = xl.check_date();
		this.gioitinh = xl.Check_sex();
		this.xeploai = xeploai(this.diemthi); 
	}
	
	public String xeploai(float diem) {
		if (diem>=8) {return "Giỏi";} else if(diem>6) {return "Khá";} else if (diem>4) {return "Trung bình";} else {return "Yếu";}

	}
	
	public void xuatSV() {
		System.out.println("Mã sinh viên:\t\t" + this.MaSV);
		System.out.println("Họ tên sinh viên:\t" + this.hoten);
		System.out.println("Giới tính:\t\t" + this.gioitinh);
		System.out.println("Ngày sinh:\t\t" + this.Ngaysinh);
		System.out.println("Điểm thi:\t\t" + this.diemthi);
		System.out.println("Điểm thi:\t\t" + this.xeploai);
	}
	
	
}
