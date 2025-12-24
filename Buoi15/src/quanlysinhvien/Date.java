package quanlysinhvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Date {
    private LocalDate ngay;
    
    public Date() {
        this.ngay = LocalDate.now();
    }
    
    public Date(LocalDate ngay) {
        this.ngay = ngay;
    }
    
    public Date(int ngay, int thang, int nam) {
        this.ngay = LocalDate.of(nam, thang, ngay);
    }
    
    // Getter - Setter
    public LocalDate getNgay() {
        return ngay;
    }
    
    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }
    
    public int getNgayTrongThang() {
        return ngay.getDayOfMonth();
    }
    
    public int getThang() {
        return ngay.getMonthValue();
    }
    
    public int getNam() {
        return ngay.getYear();
    }
    
    // Nhập ngày từ bàn phím
    public static Date nhapNgay(String prompt, int tuoiToiThieu) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print(prompt + " (dd/MM/yyyy): ");
            String dateString = scanner.nextLine().trim();
            
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(dateString, formatter);
                
                // Kiểm tra ngày không được ở tương lai
                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Lỗi: Ngày không được ở tương lai!");
                    continue;
                }
                
                // Kiểm tra tuổi tối thiểu
                if (tuoiToiThieu > 0) {
                    int tuoi = java.time.Period.between(date, LocalDate.now()).getYears();
                    if (tuoi < tuoiToiThieu) {
                        System.out.println("Lỗi: Phải đủ " + tuoiToiThieu + " tuổi trở lên! (Tuổi hiện tại: " + tuoi + ")");
                        continue;
                    }
                }
                
                return new Date(date);
                
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ! Vui lòng nhập dd/MM/yyyy");
            }
        }
    }
    
    // Tính tuổi
    public int tinhTuoi() {
        return java.time.Period.between(ngay, LocalDate.now()).getYears();
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngay.format(formatter);
    }
    
    // Kiểm tra ngày này có sau ngày khác không
    public boolean isSau(Date ngayKhac) {
        return this.ngay.isAfter(ngayKhac.getNgay());
    }
    
    // Kiểm tra ngày này có trước ngày khác không
    public boolean isTruoc(Date ngayKhac) {
        return this.ngay.isBefore(ngayKhac.getNgay());
    }
}