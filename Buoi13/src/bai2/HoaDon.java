package bai2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import TaomoiTV.Test;

public class HoaDon {
    // Thuộc tính chung
    protected String maHoaDon;
    protected LocalDate ngayHoaDon;
    protected String tenKhachHang;
    protected String maPhong;
    protected double donGia;
    
    protected Scanner sc;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // Constructor
    public HoaDon() {
        sc = new Scanner(System.in);
    }
    
    // Getter - Setter
    public String getMaHoaDon() {
        return maHoaDon;
    }
    
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    
    public LocalDate getNgayHoaDon() {
        return ngayHoaDon;
    }
    
    public void setNgayHoaDon(LocalDate ngayHoaDon) {
        this.ngayHoaDon = ngayHoaDon;
    }
    
    public String getTenKhachHang() {
        return tenKhachHang;
    }
    
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
    
    public String getMaPhong() {
        return maPhong;
    }
    
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    public double getDonGia() {
        return donGia;
    }
    
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    // Phương thức tính thành tiền (sẽ được override bởi lớp con)
    public double tinhThanhTien() {
        return 0;
    }
    
    // Phương thức nhập thông tin chung
    public void nhapThongTin() {
        this.maHoaDon = Test.inputNonEmptyString("Mã hóa đơn: ");
        this.ngayHoaDon = inputDateWithCheck("Ngày hóa đơn");
        this.tenKhachHang = Test.inputNonEmptyString("Tên khách hàng: ");
        this.maPhong = Test.inputNonEmptyString("Mã phòng: ");
        this.donGia = Test.inputPositiveDouble("Đơn giá: ");
    }
    
    // Phương thức xuất thông tin chung
    public void xuatThongTin() {
        System.out.printf("%-12s %-12s %-25s %-10s %-12s ",
            maHoaDon,
            ngayHoaDon.format(DATE_FORMAT),
            tenKhachHang,
            maPhong,
            String.format("%.2f", donGia));
    }
    
    // Phương thức nhập ngày với kiểm tra không được ở tương lai
    protected LocalDate inputDateWithCheck(String message) {
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