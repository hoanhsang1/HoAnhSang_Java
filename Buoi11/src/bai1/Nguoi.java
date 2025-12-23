package bai1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Nguoi {
    // Thuộc tính
    protected String hoTen;
    protected Date ngaySinh;
    protected String diaChi;
    protected String cccd;
    
    protected Scanner sc;
    protected SimpleDateFormat dateFormat;
    
    // Constructor
    public Nguoi() {
        sc = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
    }
    
    // Getter - Setter
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public Date getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public String getCccd() {
        return cccd;
    }
    
    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
    
    // Tính tuổi từ ngày sinh
    public int tinhTuoi() {
        Date now = new Date();
        long diff = now.getTime() - ngaySinh.getTime();
        return (int) (diff / (1000L * 60 * 60 * 24 * 365));
    }
    
    // Phương thức nhập thông tin
    public void nhapThongTin() {
        System.out.print("Họ tên: ");
        this.hoTen = sc.nextLine().trim();
        
        // Nhập ngày sinh với kiểm tra
        while (true) {
            System.out.print("Ngày sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine().trim();
            try {
                this.ngaySinh = dateFormat.parse(ngaySinhStr);
                break;
            } catch (ParseException e) {
                System.out.println("Ngày sinh không hợp lệ! Vui lòng nhập đúng định dạng dd/MM/yyyy.");
            }
        }
        
        System.out.print("Địa chỉ: ");
        this.diaChi = sc.nextLine().trim();
        
        // Nhập CCCD với kiểm tra độ dài
        while (true) {
            System.out.print("Số CCCD (12 số): ");
            this.cccd = sc.nextLine().trim();
            if (this.cccd.matches("\\d{12}")) {
                break;
            }
            System.out.println("CCCD phải có đúng 12 chữ số!");
        }
    }
    
    // Phương thức xuất thông tin
    public void xuatThongTin() {
        System.out.printf("%-25s %-12s %-20s %-15s",
            hoTen,
            dateFormat.format(ngaySinh),
            diaChi,
            cccd);
    }
}