package quanlysinhvien;

import java.time.LocalDate;
import TaomoiTV.Test;

public abstract class SinhVien extends Person {
    // Thuộc tính chung
    protected String maSV;
    protected String gioiTinh;
    protected Faculty khoa;
    
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
    
    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public Faculty getKhoa() {
        return khoa;
    }
    
    public void setKhoa(Faculty khoa) {
        this.khoa = khoa;
    }
    
    // Phương thức trừu tượng
    public abstract String getXepLoai();
    public abstract boolean isTotNghiep();
    public abstract boolean isDuocKhenThuong(); // Thêm phương thức trừu tượng
    
    @Override
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN ===");
        
        this.maSV = Test.inputNonEmptyString("Mã sinh viên: ");
        
        // Nhập họ tên
        this.hoTen = Test.inputNonEmptyString("Họ tên: ");
        
        // Nhập giới tính
        while (true) {
            System.out.print("Giới tính (Nam/Nữ): ");
            this.gioiTinh = new java.util.Scanner(System.in).nextLine().trim();
            if (this.gioiTinh.equalsIgnoreCase("Nam") || this.gioiTinh.equalsIgnoreCase("Nữ")) {
                break;
            }
            System.out.println("Giới tính phải là 'Nam' hoặc 'Nữ'!");
        }
        
        // Nhập địa chỉ chi tiết
        System.out.println("\n--- Nhập thông tin địa chỉ ---");
        this.diaChi.nhapThongTin();
    }
    
    @Override
    public void xuatThongTin() {
        System.out.printf("%-10s %-25s %-8s %-12s %-5d %-40s ",
            maSV,
            hoTen,
            gioiTinh,
            ngaySinh.format(DATE_FORMAT),
            tinhTuoi(),
            diaChi.toStringShort());
    }
    
    // Xuất tiêu đề chung
    public static void xuatTieuDe() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                                                          DANH SÁCH SINH VIÊN");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-25s %-8s %-12s %-5s %-40s %-15s %-12s %-15s %-10s %-10s\n",
            "Mã SV", "Họ tên", "GT", "Ngày sinh", "Tuổi", "Địa chỉ", "Loại hình", "Khoa", "Thông tin", "Điểm", "Xếp loại");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}