package bai1;
import java.util.*;
import java.text.*;


public class Xuly {
	Scanner inform = new Scanner(System.in);
	public int inputINT() {
		int result;
		while (true) {
			try {
				result = inform.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số nguyên.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	public float inputFLOAT() {
		float result;
		while (true) {
			try {
				result = inform.nextFloat();
				break;
			} catch (InputMismatchException e) {
				System.err.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số thực.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	public float inputDiem() {
		System.out.println("Vui lòng nhập điểm từ 0 -> 10: ");
		while(true) {
			float diem = inputFLOAT();
			if (diem>=0 && diem<=10) {
				return diem;
			} else {
				System.out.println("Vui lòng nhập lại: điểm hợp lệ từ 0 -> 10:");
			}
		}
	}
	
	public void Nhapdanhsach_sv(ArrayList<sinhvien> ds, int n) {
		for (int i=0;i<n;i++) {
			sinhvien sv = new sinhvien();
			sv.taoSV();
			ds.add(sv);
		}
	}
	
	
	public String check_date() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date;
        System.out.println("write your birthday (dd/MM/yyyy):");
        inform.nextLine();
        while (true) { 
            try {
            	
                date = inform.nextLine();
                
                sdf.parse(date);
                break;
            } catch (Exception e) {
                System.out.println("write again birthday (dd/MM/yyyy):");
            }
        }
        return date; 
    }
	
	public String Check_sex() {
		String sex;
		while (true) {
			System.out.println("Nhập giới tính Nam/Nữ: ");
			sex = inform.nextLine();
			if (sex.equals("Nam") || sex.equals("Nữ")) {
				return sex;			
				
			}
		}
	}
	
	public int add_masv(ArrayList<sinhvien> ds) {
		if (ds.isEmpty()) {
			return 0;
		}else {
			return ds.size();
		}
	}
	
	public void danhsachSV(ArrayList<sinhvien> ds, int n) {
		for (int i = 0; i<n;i++) {
			sinhvien sv = new sinhvien();
			System.out.println("");
			System.out.println("Nhập sinh viên thứ "+ i);
			sv.taoSV();
			sv.MaSV=add_masv(ds);
			ds.add(sv);
		}
	}
	
	public void xuatdanhsachSV(ArrayList<sinhvien> ds) {
		for (int i = 0; i<ds.size();i++) {
			System.out.println("");
			ds.get(i).xuatSV();
		}
	}
	
	public void xuatdanhsachSV_xeploai(ArrayList<sinhvien> ds, String dk) {
		int check =0;
		for (int i = 0; i<ds.size();i++) {
			if (ds.get(i).xeploai.equalsIgnoreCase(dk)) {
				System.out.println("");
				ds.get(i).xuatSV();
				check =1;
			}
		}
		if (check==0) {
			System.out.println("Không có sinh viên nào thoả điều kiện");
		}
	}
	
	public void xuatdanhsachSV_masv(ArrayList<sinhvien> ds, int dk) {
		int check = 0;
		for (int i = 0; i<ds.size();i++) {
			if (ds.get(i).MaSV == dk) {
				System.out.println("");
				ds.get(i).xuatSV();
				check =1;
			}
		}
		if (check==0) {
			System.out.println("Không có sinh viên nào thoả điều kiện");
		}
	}
	
	
}
// e đại diện cho 1 đối tượng tổng quát