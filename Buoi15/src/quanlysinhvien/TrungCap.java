package quanlysinhvien;

import java.util.Scanner;

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
    public String getHeDaoTao() {
        return "Trung cấp (2 năm)";
    }
    
    @Override
    public void nhapThongTin(String maSV) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN TRUNG CẤP ===");
        
        // Nhập thông tin cá nhân từ lớp cha
        super.nhapThongTin(maSV);
        
        // VALIDATE TUỔI TRUNG CẤP (>= 16)
        while (tinhTuoi() < 16) {
            System.out.println("\n⚠️ LỖI: Sinh viên trung cấp phải đủ 16 tuổi!");
            System.out.println("Tuổi hiện tại: " + tinhTuoi() + " tuổi");
            System.out.print("Nhập lại ngày sinh");
            this.ngaySinh = Date.nhapNgay("", 0);
        }
        
        System.out.println("\n--- THÔNG TIN HỌC TẬP ---");
        
        // Nhập chi tiết đào tạo
        this.tenDetail = inputNonEmptyString("Chi tiết đào tạo: ");
        
        // Nhập điểm tốt nghiệp
        while (true) {
            System.out.print("Điểm tốt nghiệp (0-10): ");
            try {
                this.diemTN = Float.parseFloat(scanner.nextLine());
                if (diemTN >= 0 && diemTN <= 10) {
                    tinhXepLoai();
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 10!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
        
        System.out.println("✓ Đã nhập xong thông tin sinh viên trung cấp!");
    }
}