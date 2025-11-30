package Cau1;

import java.util.ArrayList;
import java.util.Scanner;

import Cau1.process;
import Cau1.CD;

public class Mainprogram {
	public static void main(String[] args)
	{
	//Khai báo 1 ArrayList
		ArrayList<CD> ds = new ArrayList<CD>();
		ArrayList<TypeCD> dsloai = new ArrayList<TypeCD>();
		Scanner sc = new Scanner(System.in);
		process xl = new process();
		TypeCD type = new TypeCD();
		int chon;
		int dk;
		//     Thêm (nối thêm sinh viên mới vào danh sách)
		do {
	            System.out.println("\n========== MENU QUẢN LÝ SINH VIÊN ==========");
	            System.out.println("1. Thêm CD");
	            System.out.println("2. Tính số lượng CD có trong danh sách, tính tổng giá thành của các CD");
	            System.out.println("3. sắp xếp danh sách tăng dần theo tựa CD");
	            System.out.println("4. xuất toàn bộ danh sách");
	            System.out.println("5. Tìm kiếm và xuất dữ liệu theo tên ca sỹ");
	            System.out.println("6. Thêm thể loại");
	            System.out.println("7. Hiện các thể loại");
	            System.out.println("8. Thêm cd vào thể loại");
	            System.out.println("9. Hiện thể loại cụ thể");
	            System.out.println("10. Thoát");
	            chon = xl.inputINT();
	            
	            switch (chon) {
	                case 1:
	                    System.out.println("Nhập số CD muốn thêm");
	                    int m = xl.inputINT();
	                    xl.danhsachCD(ds, m);
	                    break;
	                case 2:
	                    xl.tinhCD(ds);
	                    break;
	                case 3:
	                	xl.sapXepTheoTua(ds);
	                	break;
	                case 4:
	                	xl.xuatdanhsachCD(ds);
	                	break;
	                case 5:
	                	System.out.println("Nhập tên ca sỹ muốn tìm: ");
	                	String casy = sc.nextLine();
	                	xl.xuatdanhsachCD_CaSy(ds, casy);
	                	break;
	                case 6:
	                	System.out.println("Nhập số lượng thể loại muốn thêm");
	                	int n = xl.inputINT();
	                	xl.danhsach_type(dsloai,n);
	                	break;
	                	
	                case 7:
	                	xl.xuatdanhsach_type(dsloai);
	                	break;
	                case 8:
	                	System.out.println("Nhập nhập thể loại muốn thêm: ");
	                	String theloai = sc.nextLine();
	                	xl.themCDintype(dsloai,ds,theloai);
	                case 9:
	                	System.out.println("Nhập nhập thể loại muốn xem: ");
	                	String theloai1 = sc.nextLine();
	                	xl.xuatdanhsach_typeName(dsloai, theloai1);
	                case 10:
	                	break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
	            }
		}	while (chon != 0);
	}
}
