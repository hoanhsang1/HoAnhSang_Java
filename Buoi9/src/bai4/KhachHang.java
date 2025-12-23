package bai4;

import TaomoiTV.Test;

public class KhachHang {
    // Thông tin hộ sử dụng điện
    private String hoTenChuHo;
    private String soNha;
    private String maSoCongTo;
    
    private Test test;
    
    // Constructor
    public KhachHang() {
        test = new Test();
    }
    
    public KhachHang(String hoTen, String soNha, String maCongTo) {
        this.hoTenChuHo = hoTen;
        this.soNha = soNha;
        this.maSoCongTo = maCongTo;
        test = new Test();
    }
    
    // Getter - Setter
    public String getHoTenChuHo() {
        return hoTenChuHo;
    }
    
    public void setHoTenChuHo(String hoTenChuHo) {
        this.hoTenChuHo = hoTenChuHo;
    }
    
    public String getSoNha() {
        return soNha;
    }
    
    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
    
    public String getMaSoCongTo() {
        return maSoCongTo;
    }
    
    public void setMaSoCongTo(String maSoCongTo) {
        this.maSoCongTo = maSoCongTo;
    }
    
    // Nhập thông tin khách hàng (DÙNG TaomoiTV.Test)
    public void nhapThongTin() {
        System.out.println("\n--- NHẬP THÔNG TIN HỘ SỬ DỤNG ĐIỆN ---");
        
        this.hoTenChuHo = test.inputNonEmptyString("Họ tên chủ hộ: ");
        this.soNha = test.inputNonEmptyString("Số nhà: ");
        this.maSoCongTo = test.inputNonEmptyString("Mã số công tơ: ");
    }
    
    // Hiển thị thông tin khách hàng
    public void hienThiThongTin() {
        System.out.println("Chủ hộ: " + hoTenChuHo);
        System.out.println("Số nhà: " + soNha);
        System.out.println("Mã công tơ: " + maSoCongTo);
    }
}
