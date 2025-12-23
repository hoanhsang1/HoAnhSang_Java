package quanlysinhvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import TaomoiTV.Test;

public abstract class Person {
    // Thuộc tính
    protected String hoTen;
    protected LocalDate ngaySinh;
    protected DiaChi diaChi; // Thay String bằng đối tượng DiaChi
    
    protected static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // Constructor
    public Person() {
        diaChi = new DiaChi();
    }
    
    // Getter - Setter
    public String getHoTen() {
        return hoTen;
    }
    
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public DiaChi getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }
    
    // Tính tuổi
    public int tinhTuoi() {
        return Period.between(ngaySinh, LocalDate.now()).getYears();
    }
    
    // Phương thức trừu tượng
    public abstract void nhapThongTin();
    public abstract void xuatThongTin();
    
    // Phương thức nhập ngày sinh với kiểm tra tuổi tối thiểu
    protected LocalDate inputNgaySinh(int tuoiToiThieu) {
        while (true) {
            System.out.print("Ngày sinh (dd/MM/yyyy): ");
            String dateString = new java.util.Scanner(System.in).nextLine();
            try {
                LocalDate date = LocalDate.parse(dateString, DATE_FORMAT);
                LocalDate today = LocalDate.now();
                
                // Kiểm tra ngày không được ở tương lai
                if (date.isAfter(today)) {
                    System.out.println("Lỗi: Ngày sinh không được ở tương lai!");
                    continue;
                }
                
                // Kiểm tra tuổi tối thiểu
                int tuoi = Period.between(date, today).getYears();
                if (tuoi < tuoiToiThieu) {
                    System.out.println("Lỗi: Phải đủ " + tuoiToiThieu + " tuổi trở lên! (Tuổi hiện tại: " + tuoi + ")");
                    continue;
                }
                
                return date;
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ!");
            }
        }
    }
}