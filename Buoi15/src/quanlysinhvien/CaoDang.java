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
    public String getHeDaoTao() {
        return "Cao đẳng (3 năm)";
    }
    
    @Override
    public void nhapThongTin(String maSV) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN CAO ĐẲNG ===");
        
        // Nhập thông tin cá nhân từ lớp cha
        super.nhapThongTin(maSV);
        
        // VALIDATE TUỔI CAO ĐẲNG (>= 18)
        while (tinhTuoi() < 18) {
            System.out.println("\n⚠️ LỖI: Sinh viên cao đẳng phải đủ 18 tuổi!");
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
        
        System.out.println("✓ Đã nhập xong thông tin sinh viên cao đẳng!");
    }
}