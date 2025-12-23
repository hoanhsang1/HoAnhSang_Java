package quanlysinhvien;

import TaomoiTV.Test;

public abstract class SinhVienNienChe extends SinhVien {
    // Thuộc tính chung cho niên chế
    protected int nienChe; // số năm
    protected String tenDetail;
    protected float diemTN; // thang điểm 10
    protected String xepLoai; // Giỏi, Khá, TB, Yếu
    
    // Constructor
    public SinhVienNienChe() {
        super();
    }
    
    // Getter - Setter
    public int getNienChe() {
        return nienChe;
    }
    
    public abstract void setNienChe(); // Phương thức trừu tượng
    
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
        return diemTN >= 5; // Điểm tốt nghiệp >= 5
    }
    
    // Triển khai isDuocKhenThuong cho hệ niên chế
    @Override
    public boolean isDuocKhenThuong() {
        return xepLoai.equals("Giỏi");
    }
    
    @Override
    public void nhapThongTin() {
        // Nhập thông tin chung
        super.nhapThongTin();
        
        // Nhập thông tin học tập
        this.tenDetail = Test.inputNonEmptyString("Chi tiết đào tạo: ");
        
        // Nhập điểm tốt nghiệp (0-10)
        while (true) {
            System.out.print("Điểm tốt nghiệp (0-10): ");
            try {
                this.diemTN = Float.parseFloat(new java.util.Scanner(System.in).nextLine());
                if (diemTN >= 0 && diemTN <= 10) {
                    tinhXepLoai();
                    break;
                }
                System.out.println("Điểm phải từ 0 đến 10!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
    
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-15s %-12s %-15s %-10s %-10s\n",
            "Niên chế (" + nienChe + " năm)",
            (khoa != null ? khoa.getTenKhoa() : "Chưa có"),
            tenDetail,
            String.format("%.2f", diemTN),
            xepLoai + (isTotNghiep() ? " ✓" : ""));
    }
}