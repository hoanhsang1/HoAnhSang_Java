package quanlysinhvien;

public class TrungCap extends SinhVienNienChe {
    
    public TrungCap() {
        super();
        setNienChe();
    }
    
    @Override
    public void setNienChe() {
        this.nienChe = 2; // Trung cấp 2 năm
    }
    
    @Override
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN TRUNG CẤP ===");
        
        // Nhập thông tin chung
        super.nhapThongTin();
        
        // Nhập ngày sinh (trung cấp phải trên 16 tuổi)
        System.out.println("\n--- Thông tin sinh viên Trung cấp ---");
        this.ngaySinh = inputNgaySinh(16);
    }
}