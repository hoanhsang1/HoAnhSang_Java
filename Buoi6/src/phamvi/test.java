package phamvi;

import java.util.*;

class test {
	public static void main(String[] args) {
		ArrayList<phanso> ds = new ArrayList<phanso>();
		phanso ps = new phanso();
		Scanner sc = new Scanner(System.in);
		Xuly xl = new Xuly();
		int chon;
		int dk;
		//     Thêm (nối thêm sinh viên mới vào danh sách)
		do {
	            System.out.println("\n========== MENU QUẢN LÝ SINH VIÊN ==========");
	            System.out.println("1. Nhập tử số mẫu số");
	            System.out.println("2. Xuất DS sinh viên");
	            System.out.println("3. Tìm sinh viên theo xếp loại");
	            System.out.println("4. Tìm sinh viên theo mã sinh viên");
	            System.out.println("0. Thoát");
	            chon = xl.inputINT();
	            
	            switch (chon) {
	                case 1:
	                    ps.Nhap();
	                    break;
	                case 2:
	                    ps.Xuat();
	                    break;
//	                case 3:
//	                	System.out.println("\n========== MENU QUẢN LÝ SINH VIÊN ==========");
//	    	            System.out.println("1. Xếp loại giỏi");
//	    	            System.out.println("2. Xếp loại khá");
//	    	            System.out.println("3. Xếp loại trung bình");
//	    	            System.out.println("4. Xếp loại yếu");
//	    	            dk = xl.inputINT();
//	                	switch (dk){
//		                	case 1:
//		                		xl.xuatdanhsachSV_xeploai(ds,"Giỏi");
//		                		break;
//		                	case 2:
//		                		xl.xuatdanhsachSV_xeploai(ds,"Khá");
//		                		break;
//		                	case 3:
//		                		xl.xuatdanhsachSV_xeploai(ds,"Trung Bình");
//		                		break;
//		                	case 4:
//		                		xl.xuatdanhsachSV_xeploai(ds,"Yếu");
//		                		break;
//		                	default:
//			                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
//	                		
//	                	}
//	                    break;
//	                case 4:
//	                	System.out.println("Vui lòng nhập mã sinh viên muốn tìm kiếm: ");
//	                	dk = xl.inputINT();
//	                	xl.xuatdanhsachSV_masv(ds, dk);
//	                	break;
	                case 0:
	                    System.out.println("Thoát chương trình. Tạm biệt!");
	                    break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
	            }
	        } while (chon != 0);
	}
}
