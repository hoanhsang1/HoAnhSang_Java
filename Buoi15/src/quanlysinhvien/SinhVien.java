package quanlysinhvien;

import java.util.Scanner;

public abstract class SinhVien extends Person {
    protected String maSV;
    protected String gioiTinh;
    protected Faculty khoa;
    
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
    public abstract boolean isDuocKhenThuong();
    public abstract float getDiem();
    public abstract String getHeDaoTao();
    public abstract void capNhatDiem(); // Cập nhật điểm
    
    public void nhapThongTin(String maSV) {
        Scanner scanner = new Scanner(System.in);
        
        // Gán mã sinh viên
        this.maSV = maSV;
        
        System.out.println("\n--- THÔNG TIN CÁ NHÂN ---");
        
        // Nhập họ tên
        this.hoTen = inputNonEmptyString("Họ tên: ");
        
        // Nhập giới tính
        while (true) {
            System.out.print("Giới tính (Nam/Nữ): ");
            this.gioiTinh = scanner.nextLine().trim();
            if (this.gioiTinh.equalsIgnoreCase("Nam") || this.gioiTinh.equalsIgnoreCase("Nữ")) {
                break;
            }
            System.out.println("Giới tính phải là 'Nam' hoặc 'Nữ'!");
        }
        
        // Nhập ngày sinh (tuổi tối thiểu sẽ được validate trong lớp con)
        System.out.print("Nhập ngày sinh");
        this.ngaySinh = Date.nhapNgay("", 0);
        
        // Nhập địa chỉ
        this.diaChi.nhapThongTin();
    }
    @Override
    public void nhapThongTin() {
        // Không dùng
    }
    
    @Override
    public void xuatThongTin() {
        System.out.printf("%-10s %-25s %-8s %-12s %-5d %-40s ",
            maSV, hoTen, gioiTinh, ngaySinh.toString(), 
            tinhTuoi(), diaChi.toStringShort());
    }
    
    // Xuất thông tin chi tiết
    public void xuatThongTinChiTiet() {
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("          THÔNG TIN SINH VIÊN");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("Mã SV: " + maSV);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Ngày sinh: " + ngaySinh.toString() + " (Tuổi: " + tinhTuoi() + ")");
        System.out.println("Địa chỉ: " + diaChi.toString());
        System.out.println("Khoa: " + (khoa != null ? khoa.getTenKhoa() : "Chưa có"));
        System.out.println("Hệ đào tạo: " + getHeDaoTao());
        System.out.println("══════════════════════════════════════════════");
    }
    
    // Xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                                                          DANH SÁCH SINH VIÊN");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-25s %-8s %-12s %-5s %-40s %-15s %-12s %-15s %-10s %-10s\n",
            "Mã SV", "Họ tên", "GT", "Ngày sinh", "Tuổi", "Địa chỉ", "Loại hình", "Khoa", "Thông tin", "Điểm", "Xếp loại");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}