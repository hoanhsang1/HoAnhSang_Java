package bai1;

import java.text.ParseException;

public class SinhVien extends Nguoi {
    // Thuộc tính riêng
    private String maSV;
    private double diemRenLuyen;
    
    // Constructor
    public SinhVien() {
        super();
    }
    
    // Getter - Setter
    public String getMaSV() {
        return maSV;
    }
    
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    
    public double getDiemRenLuyen() {
        return diemRenLuyen;
    }
    
    public void setDiemRenLuyen(double diemRenLuyen) {
        // Kiểm tra điểm từ 0-100
        if (diemRenLuyen < 0) {
            this.diemRenLuyen = 0;
        } else if (diemRenLuyen > 100) {
            this.diemRenLuyen = 100;
        } else {
            this.diemRenLuyen = diemRenLuyen;
        }
    }
    
    // Phương thức xếp loại rèn luyện
    public String xepLoaiRenLuyen() {
        if (diemRenLuyen >= 90) return "Giỏi";
        else if (diemRenLuyen >= 80) return "Khá";
        else if (diemRenLuyen >= 65) return "Trung bình";
        else return "Yếu";
    }
    
    // Phương thức nhập thông tin sinh viên
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN ===");
        
        // Nhập thông tin chung từ lớp cha
        super.nhapThongTin();
        
        // Kiểm tra tuổi >= 18
        while (tinhTuoi() < 18) {
            System.out.println("Sinh viên phải đủ 18 tuổi trở lên! (Tuổi hiện tại: " + tinhTuoi() + ")");
            System.out.print("Nhập lại ngày sinh (dd/MM/yyyy): ");
            try {
                String ngaySinhStr = sc.nextLine().trim();
                this.ngaySinh = dateFormat.parse(ngaySinhStr);
            } catch (ParseException e) {
                System.out.println("Ngày sinh không hợp lệ!");
            }
        }
        
        // Nhập mã sinh viên
        System.out.print("Mã sinh viên: ");
        this.maSV = sc.nextLine().trim();
        
        // Nhập điểm rèn luyện
        while (true) {
            try {
                System.out.print("Điểm rèn luyện (0-100): ");
                this.diemRenLuyen = Double.parseDouble(sc.nextLine());
                if (this.diemRenLuyen >= 0 && this.diemRenLuyen <= 100) {
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 100!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
    
    // Phương thức xuất thông tin sinh viên
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf(" %-15s %-8.2f %-12s\n",
            maSV,
            diemRenLuyen,
            xepLoaiRenLuyen());
    }
    
    // Phương thức xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                    DANH SÁCH SINH VIÊN");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-25s %-12s %-20s %-15s %-15s %-8s %-12s\n",
            "Họ tên", "Ngày sinh", "Địa chỉ", "CCCD", "Mã SV", "Điểm RL", "Xếp loại");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}