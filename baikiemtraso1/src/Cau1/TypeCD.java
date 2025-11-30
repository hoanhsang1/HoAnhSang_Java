package Cau1;
import java.util.*;
import Cau1.process;
import Cau1.CD;

public class TypeCD {;
		process xl = new process();
		int MaLoai;
		String Tenloai;
		int SL;
		
		ArrayList<CD> danhSachCD; 
	    
	    // Constructor để khởi tạo danh sách CD
	    public void addTypeCD() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Nhập tên thể loại:");
	    	this.Tenloai = sc.nextLine();
	        this.danhSachCD = new ArrayList<CD>();
	        this.SL = 0; 
	    }
		
		public void themCD_type(CD cd) {
	        this.danhSachCD.add(cd);
	        this.SL = this.danhSachCD.size(); // Cập nhật số lượng
	    }
		
		
		public void xuatCD_type() {
	        System.out.println("\n*** THỂ LOẠI: " + this.Tenloai.toUpperCase() + " ***");
	        System.out.println("Mã thể loại là:\t\t\t" + this.MaLoai);
	        System.out.println("Số lượng CD của thể loại là:\t" + this.SL);

	        // Xuất danh sách chi tiết các CD trong thể loại này
	        if (SL > 0) {
	            System.out.println("--- Danh sách chi tiết CD ---");
	            for(CD cd : danhSachCD) {
	                cd.xuatCD(); 
	                System.out.println("---");
	            }
	        } else {
	            System.out.println("(Không có CD nào trong thể loại này)");
	        }
	    }
}
