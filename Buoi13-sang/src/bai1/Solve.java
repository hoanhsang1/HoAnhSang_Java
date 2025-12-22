package bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Solve {
	ArrayList<Sach> ds = new ArrayList<Sach>();
	static Scanner sc = new Scanner(System.in);
    public boolean isMaSTonTai(String MaS) {
        for (Sach emp : ds) {
            if (emp.getMaS().equalsIgnoreCase(MaS)) {
                return true; // Mã đã tồn tại
            }
        }
        return false; // Mã chưa tồn tại
    }
    
    public String nhapMaS() {
        String MaS;
        while (true) {
            System.out.print("Nhập mã sách: ");
            MaS = sc.nextLine().trim();
            
            if (MaS.isEmpty()) {
                System.out.println("Lỗi: Mã sách không được để trống!");
                continue;
            }
            
            if (isMaSTonTai(MaS)) {
                System.out.println("Lỗi: Mã sách '" + MaS + "' đã tồn tại!");
                System.out.println("Vui lòng nhập mã khác.");
            } else {
                break; // Mã hợp lệ và duy nhất
            }
        }
        return MaS;
    }
}
