package bai1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import TaomoiTV.Test;

public class Sach {
    // Thuộc tính chung
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;
    
    private Scanner sc;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // Constructor
    public Sach() {
        sc = new Scanner(System.in);
    }
    
    // Getter - Setter
    public String getMaSach() {
        return maSach;
    }
    
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    
    public LocalDate getNgayNhap() {
        return ngayNhap;
    }
    
    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public double getDonGia() {
        return donGia;
    }
    
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    
    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
    
    // Phương thức tính thành tiền (sẽ được override bởi lớp con)
    public double tinhThanhTien() {
        return 0;
    }
    
    // Phương thức nhập thông tin chung
    public void nhapThongTin() {
        this.maSach = Test.inputNonEmptyString("Mã sách: ");
        
        // Nhập ngày với kiểm tra không được ở tương lai
        this.ngayNhap = inputDateWithCheck("Ngày nhập");
        
        this.donGia = Test.inputPositiveDouble("Đơn giá: ");
        this.soLuong = Test.inputPositiveInt("Số lượng: ");
        this.nhaXuatBan = Test.inputNonEmptyString("Nhà xuất bản: ");
    }
    
    // Phương thức xuất thông tin chung
    public void xuatThongTin() {
        System.out.printf("%-10s %-12s %-12s %-8d %-15s ",
            maSach,
            ngayNhap.format(DATE_FORMAT),
            String.format("%.2f", donGia),
            soLuong,
            nhaXuatBan);
    }
    
    // Phương thức nhập ngày với kiểm tra không được tương lai
    private LocalDate inputDateWithCheck(String message) {
        while (true) {
            System.out.print(message + " (dd/MM/yyyy): ");
            String dateString = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateString, DATE_FORMAT);
                LocalDate today = LocalDate.now();
                
                // Kiểm tra ngày không được ở tương lai
                if (date.isAfter(today)) {
                    System.out.println("Lỗi: Ngày không được ở tương lai! Vui lòng nhập lại.");
                    continue;
                }
                return date;
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}