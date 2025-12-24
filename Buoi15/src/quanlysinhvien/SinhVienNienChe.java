package quanlysinhvien;

import java.util.Scanner;

public abstract class SinhVienNienChe extends SinhVien {
    protected int nienChe;
    protected String tenDetail;
    protected float diemTN;
    protected String xepLoai;
    
    public SinhVienNienChe() {
        super();
    }
    
    // Getter - Setter
    public int getNienChe() {
        return nienChe;
    }
    
    public abstract void setNienChe();
    
    public String getTenDetail() {
        return tenDetail;
    }
    
    public void setTenDetail(String tenDetail) {
        this.tenDetail = tenDetail;
    }
    
    public float getDiemTN() {
        return diemTN;
    }
    
    public void setDiemTN(float diemTN) {
        this.diemTN = diemTN;
        tinhXepLoai();
    }
    
    @Override
    public String getXepLoai() {
        return xepLoai;
    }
    
    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }
    
    // Tính xếp loại
    protected void tinhXepLoai() {
        if (diemTN >= 8) xepLoai = "Giỏi";
        else if (diemTN >= 6.5) xepLoai = "Khá";
        else if (diemTN >= 5) xepLoai = "Trung bình";
        else xepLoai = "Yếu";
    }
    
    // Kiểm tra tốt nghiệp
    @Override
    public boolean isTotNghiep() {
        return diemTN >= 5;
    }
    
    // Được khen thưởng
    @Override
    public boolean isDuocKhenThuong() {
        return xepLoai.equals("Giỏi");
    }
    
    @Override
    public float getDiem() {
        return diemTN;
    }
    
    @Override
    public String getHeDaoTao() {
        return "Niên chế (" + nienChe + " năm)";
    }
    
    @Override
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
        
        // Nhập ngày sinh
        System.out.print("Nhập ngày sinh");
        this.ngaySinh = Date.nhapNgay("", 0);
        
        // Nhập địa chỉ
        this.diaChi.nhapThongTin();
    }
    
    @Override
    public void capNhatDiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== CẬP NHẬT ĐIỂM SINH VIÊN NIÊN CHẾ ===");
        
        System.out.print("Chi tiết đào tạo mới (Enter để giữ nguyên): ");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            this.tenDetail = input;
        }
        
        System.out.print("Điểm tốt nghiệp mới (Enter để giữ nguyên): ");
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            this.diemTN = Float.parseFloat(input);
            tinhXepLoai();
        }
        
        System.out.println("✓ Đã cập nhật điểm!");
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-15s %-12s %-15s %-10s %-10s\n",
            "Niên chế (" + nienChe + " năm)",
            (khoa != null ? khoa.getTenKhoa() : "Chưa có"),
            tenDetail, String.format("%.2f", diemTN),
            xepLoai + (isTotNghiep() ? " ✓TN" : ""));
    }
}