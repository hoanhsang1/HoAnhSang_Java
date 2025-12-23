package quanlysinhvien;

import java.util.Scanner;

public class CaoDang extends SinhVienNienChe {
    
    public CaoDang() {
        super();
        setNienChe();
    }
    
    @Override
    public void setNienChe() {
        this.nienChe = 3; // Cao đẳng 3 năm
    }
    
    @Override
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN CAO ĐẲNG ===");
        
        // Nhập thông tin chung
        super.nhapThongTin();
        
        // Nhập ngày sinh (cao đẳng phải trên 18 tuổi)
        System.out.println("\n--- Thông tin sinh viên Cao đẳng ---");
        this.ngaySinh = inputNgaySinh(18);
    }
}