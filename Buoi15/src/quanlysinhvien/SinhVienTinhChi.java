package quanlysinhvien;

import TaomoiTV.Test;

public class SinhVienTinhChi extends SinhVien {
    // Thuộc tính riêng
    private int tinChi;
    private String tenDeTai;
    private float diemDG; // thang điểm 5
    private String xepLoai; // A, B, C, D
    
    // Constructor
    public SinhVienTinhChi() {
        super();
    }
    
    // Getter - Setter
    public int getTinChi() {
        return tinChi;
    }
    
    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }
    
    public String getTenDeTai() {
        return tenDeTai;
    }
    
    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }
    
    public float getDiemDG() {
        return diemDG;
    }
    
    public void setDiemDG(float diemDG) {
        this.diemDG = diemDG;
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
    private void tinhXepLoai() {
        if (diemDG >= 4.5) xepLoai = "A";
        else if (diemDG >= 3.5) xepLoai = "B";
        else if (diemDG >= 2.5) xepLoai = "C";
        else xepLoai = "D";
    }
    
    // Kiểm tra tốt nghiệp
    @Override
    public boolean isTotNghiep() {
        return tinChi >= 120 && diemDG >= 2.5; // Đủ 120 tín chỉ và điểm >= 2.5
    }
    
    // Triển khai isDuocKhenThuong cho hệ tín chỉ
    @Override
    public boolean isDuocKhenThuong() {
        return xepLoai.equals("A");
    }
    
    @Override
    public void nhapThongTin() {
        // Nhập thông tin chung
        super.nhapThongTin();
        
        // Nhập ngày sinh (đại học phải trên 18 tuổi)
        System.out.println("\n--- Thông tin sinh viên Đại học (Tín chỉ) ---");
        this.ngaySinh = inputNgaySinh(18);
        
        // Nhập thông tin học tập
        this.tinChi = Test.inputPositiveInt("Số tín chỉ: ");
        this.tenDeTai = Test.inputNonEmptyString("Tên đề tài tốt nghiệp: ");
        
        // Nhập điểm đánh giá (0-5)
        while (true) {
            System.out.print("Điểm đánh giá (0-5): ");
            try {
                this.diemDG = Float.parseFloat(new java.util.Scanner(System.in).nextLine());
                if (diemDG >= 0 && diemDG <= 5) {
                    tinhXepLoai();
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 5!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-15s %-12s %-15s %-10s %-10s\n",
            "Đại học (TC)",
            (khoa != null ? khoa.getTenKhoa() : "Chưa có"),
            "Tín chỉ: " + tinChi,
            String.format("%.2f", diemDG),
            xepLoai + (isTotNghiep() ? " ✓" : ""));
    }
}