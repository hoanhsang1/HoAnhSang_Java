package quanlysinhvien;

import TaomoiTV.Test;

public class DiaChi {
    // Thuộc tính
    private String soNha;
    private String duong;
    private String phuongXa;
    private String quanHuyen;
    private String tinhThanh;
    
    // Constructor
    public DiaChi() {
    }
    
    // Constructor có tham số
    public DiaChi(String soNha, String duong, String phuongXa, String quanHuyen, String tinhThanh) {
        this.soNha = soNha;
        this.duong = duong;
        this.phuongXa = phuongXa;
        this.quanHuyen = quanHuyen;
        this.tinhThanh = tinhThanh;
    }
    
    // Getter - Setter
    public String getSoNha() {
        return soNha;
    }
    
    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
    
    public String getDuong() {
        return duong;
    }
    
    public void setDuong(String duong) {
        this.duong = duong;
    }
    
    public String getPhuongXa() {
        return phuongXa;
    }
    
    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }
    
    public String getQuanHuyen() {
        return quanHuyen;
    }
    
    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }
    
    public String getTinhThanh() {
        return tinhThanh;
    }
    
    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
    
    // Nhập thông tin địa chỉ
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN ĐỊA CHỈ ===");
        System.out.print("Số nhà: ");
        this.soNha = new java.util.Scanner(System.in).nextLine().trim();
        System.out.print("Đường: ");
        this.duong = new java.util.Scanner(System.in).nextLine().trim();
        System.out.print("Phường/Xã: ");
        this.phuongXa = new java.util.Scanner(System.in).nextLine().trim();
        System.out.print("Quận/Huyện: ");
        this.quanHuyen = new java.util.Scanner(System.in).nextLine().trim();
        System.out.print("Tỉnh/Thành phố: ");
        this.tinhThanh = new java.util.Scanner(System.in).nextLine().trim();
    }
    
    // Xuất thông tin địa chỉ
    @Override
    public String toString() {
        return soNha + " " + duong + ", " + phuongXa + ", " + quanHuyen + ", " + tinhThanh;
    }
    
    // Xuất thông tin ngắn gọn
    public String toStringShort() {
        return soNha + " " + duong + ", " + quanHuyen + ", " + tinhThanh;
    }
}