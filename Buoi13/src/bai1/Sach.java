package bai1;

import TaomoiTV.Test;
import java.time.LocalDate;
// Sử dụng LocalDate để quản lý Ngày nhập

public abstract class Sach {
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    // Constructor không tham số (Luôn luôn có)
    public Sach() {}

    public Sach(String ms, LocalDate day, double dg, int sl, String nxb) {
    	this.maSach=ms;
    	this.ngayNhap=day;
    	this.donGia=dg;
    	this.soLuong=sl;
    	this.nhaXuatBan=nxb;
		
	}

	// Phương thức Nhập thông tin chung
    public void nhap() {
        System.out.println("--- NHẬP THÔNG TIN SÁCH ---");
        // Dùng thư viện Test của bạn
        this.maSach = Test.inputNonEmptyString("  Nhập Mã sách: ");
        
        // Giả sử Test.inputDate nhập ngày tháng năm theo định dạng "dd/MM/yyyy"
        this.ngayNhap = Test.inputDate("  Nhập Ngày nhập"); 
        
        // Đơn giá và Số lượng phải dương (Sử dụng hàm inputPositiveDouble/Int đã thống nhất)
        this.donGia = Test.inputPositiveDouble("  Nhập Đơn giá (> 0): ");
        this.soLuong = Test.inputPositiveInt("  Nhập Số lượng (> 0): ");
        this.nhaXuatBan = Test.inputNonEmptyString("  Nhập Nhà xuất bản: ");
    }
    
    // Phương thức Xuất thông tin chung
    public String xuatCoBan() {
        // Dùng định dạng ngày tháng của Test
        String ngay = ngayNhap != null ? ngayNhap.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "N/A";
        return String.format("| %-10s | %-12s | %-10.2f | %-8d | %-20s", 
            maSach, ngay, donGia, soLuong, nhaXuatBan);
    }
    
    // Phương thức trừu tượng: Tính thành tiền (bắt buộc lớp con phải định nghĩa)
    public abstract double tinhThanhTien();
    
    // Getters cần thiết cho việc xử lý ở lớp QuanLySach
    public double getDonGia() { return donGia; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public String getMaSach() { return maSach; }
}