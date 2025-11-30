package Cau1;
import java.util.*;
import Cau1.TypeCD;
import Cau1.CD;

public class process {
	Scanner inform = new Scanner(System.in);
	public int inputINT() {
		int result;
		while (true) {
			try {
				result = inform.nextInt();
				if (result>0 ) {
					break;
				}
				System.out.print("Vui lòng nhập lại dữ liệu lớn hơn 0: ");
			} catch (InputMismatchException e) {
				System.err.println("! Lỗi dữ liệu: Vui lòng chỉ nhập số nguyên.");
				System.out.print("Vui lòng nhập lại dữ liệu: ");
				inform.next();
				continue;
			}
		}
		return result;
	}
	
	public int add_macd(ArrayList<CD> ds) {
		if (ds.isEmpty()) {
			return 1;
		}else {
			return ds.size()+1;
		}
	}
	
	public int add_maloai(ArrayList<TypeCD> ds) {
		if (ds.isEmpty()) {
			return 1;
		}else {
			return ds.size()+1;
		}
	}
	
	public void danhsachCD(ArrayList<CD> ds, int n) {
		for (int i = 0; i<n;i++) {
			CD cd = new CD();
			System.out.println("");
			System.out.println("Nhập CD thứ "+ i);
			cd.taoCD();
			cd.MaCD=add_macd(ds);
			ds.add(cd);
		}
	}
	
	public void xuatdanhsachCD(ArrayList<CD> ds) {
		for (int i = 0; i<ds.size();i++) {
			System.out.println("");
			ds.get(i).xuatCD();
		}
	}
	
	public void tinhCD(ArrayList<CD> ds) {
		System.out.println("Tổng số CD là: " + ds.size());
		float result = 0;
		if (ds.isEmpty()) {
			System.out.println("Không có CD nào để tính toán");
		} else {
			for (int i = 0; i<ds.size();i++) {
				result = result + ds.get(i).GiaThanh;
			}
			System.out.println("Tổng số giá thành của các CD là: " + result);
		}
		
	}
	
	public void sapXepTheoTua(ArrayList<CD> ds) {
        Collections.sort(ds, new Comparator<CD>() {
            
            public int compare(CD a, CD b) {
                return a.tuaCD.compareToIgnoreCase(b.tuaCD);
            }
        });

        System.out.println("✔ Đã sắp xếp theo tựa CD!");
    }
	
	public void xuatdanhsachCD_CaSy(ArrayList<CD> ds, String dk) {
		int check = 0;
		for (int i = 0; i<ds.size();i++) {
			if (ds.get(i).CaSy.equalsIgnoreCase(dk)) {
				System.out.println("");
				ds.get(i).xuatCD();
				check =1;
			}
		}
		if (check==0) {
			System.out.println("Không tìm thấy CD của ca sỹ (đã nhập)");	
		}
	}
	
	public CD xuatdanhsachCD_ID(ArrayList<CD> ds, int dk) {
		
		for (int i = 0; i<ds.size();i++) {
			if (ds.get(i).MaCD==dk) {
				System.out.println("");
				return ds.get(i);
			}
		}
		
		System.out.println("Không tìm thấy CD của ca sỹ (đã nhập)");	
		return null;
	}
	
	
	public void danhsach_type(ArrayList<TypeCD> ds, int n) {
		for (int i = 0; i<n;i++) {
			TypeCD type = new TypeCD();
			System.out.println("");
			System.out.println("Nhập thể loại thứ "+ i);
			type.addTypeCD();
			type.MaLoai=add_maloai(ds);
			ds.add(type);
		}
	}
	
	public void xuatdanhsach_type(ArrayList<TypeCD> ds) {
		for (int i = 0; i<ds.size();i++) {
			System.out.println("");
			ds.get(i).xuatCD_type();
		}
	}
	
	public void xuatdanhsach_typeName(ArrayList<TypeCD> ds, String dk) {
		int check = 0;
		for (int i = 0; i<ds.size();i++) {
			System.out.println("");
			if (ds.get(i).Tenloai.equalsIgnoreCase(dk)) {
				System.out.println("");
				ds.get(i).xuatCD_type();
				check = 1;
			}
			
		}
		if (check==0) {
			System.out.println("Không tìm thấy thể (đã nhập)");
		}
	}
	
	public void themCDintype(ArrayList<TypeCD> dsTheLoai, ArrayList<CD> danhSachCDChung, String tenTheLoai) {
	    TypeCD theLoaiCanTim = null;

	    // 1. Tìm Thể loại theo tên
	    for (TypeCD tl : dsTheLoai) {
	        if (tl.Tenloai.trim().equalsIgnoreCase(tenTheLoai.trim())) {
	            theLoaiCanTim = tl;
	            break; // Tìm thấy thì dừng
	        }
	    }

	    if (theLoaiCanTim != null) {
	        System.out.println("=> Đã tìm thấy thể loại: " + theLoaiCanTim.Tenloai);
	        System.out.print("Nhập Mã CD cần thêm vào thể loại này: ");

	        // Lấy Mã CD từ người dùng
	        int maCD = inputINT(); 
	        
	        // 2. Tìm CD theo Mã CD từ DANH SÁCH CD CHUNG
	        // Hàm này phải trả về CD hoặc null
	        CD cdCanThem = xuatdanhsachCD_ID(danhSachCDChung, maCD); 

	        if (cdCanThem != null) {
	            // 3. Thêm CD vào thể loại
	            theLoaiCanTim.themCD_type(cdCanThem); // Gọi hàm thêm CD vào danh sách CD nội bộ của TypeCD
	            System.out.println("=> Đã thêm CD '" + cdCanThem.tuaCD + "' vào thể loại " + theLoaiCanTim.Tenloai);
	        } 
	        else {
	            // Thông báo nếu không tìm thấy CD theo ID
	            System.out.println("Không tìm thấy CD có Mã " + maCD + " trong danh sách chung.");
	        }
	    } else {
	        // Thông báo nếu không tìm thấy Thể loại
	        System.out.println("Không tìm thấy thể loại (đã nhập): " + tenTheLoai);
	    }
	}
	
}
