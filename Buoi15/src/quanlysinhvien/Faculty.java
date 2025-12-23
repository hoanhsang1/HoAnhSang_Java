package quanlysinhvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Faculty {
    // Thuộc tính
    private String maKhoa;
    private String tenKhoa;
    private LocalDate ngayThanhLap;
    private School truong; // Khoa thuộc về trường nào
    
    // Constructor
    public Faculty() {
    }
    
    // Constructor có tham số
    public Faculty(String maKhoa, String tenKhoa, School truong) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.truong = truong;
    }
    
    // Getter - Setter
    public String getMaKhoa() {
        return maKhoa;
    }
    
    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
    
    public String getTenKhoa() {
        return tenKhoa;
    }
    
    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
    
    public LocalDate getNgayThanhLap() {
        return ngayThanhLap;
    }
    
    public void setNgayThanhLap(LocalDate ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }
    
    public School getTruong() {
        return truong;
    }
    
    public void setTruong(School truong) {
        this.truong = truong;
    }
    
    // Nhập thông tin khoa
    public void nhapThongTin(School truongHienTai) {
        System.out.println("\n=== NHẬP THÔNG TIN KHOA ===");
        
        // Gán trường cho khoa
        this.truong = truongHienTai;
        
        System.out.print("Mã khoa: ");
        this.maKhoa = new Scanner(System.in).nextLine().trim();
        System.out.print("Tên khoa: ");
        this.tenKhoa = new Scanner(System.in).nextLine().trim();
        
        // Nhập ngày thành lập
        while (true) {
            System.out.print("Ngày thành lập (dd/MM/yyyy): ");
            String dateString = new Scanner(System.in).nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.ngayThanhLap = LocalDate.parse(dateString, formatter);
                
                // Kiểm tra ngày thành lập khoa không được trước ngày thành lập trường
                if (this.ngayThanhLap.isBefore(truongHienTai.getNgayThanhLap())) {
                    System.out.println("Ngày thành lập khoa không được trước ngày thành lập trường!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ!");
            }
        }
    }
    
    // Xuất thông tin khoa
    public void xuatThongTin() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-10s %-25s %-12s %-15s\n",
            maKhoa,
            tenKhoa,
            ngayThanhLap.format(formatter),
            (truong != null ? truong.getTenTruong() : "Chưa có trường"));
    }
    public void xuatThongTinDayDu() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("            THÔNG TIN CHI TIẾT KHOA");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("Mã khoa: " + maKhoa);
        System.out.println("Tên khoa: " + tenKhoa);
        System.out.println("Ngày thành lập: " + ngayThanhLap.format(formatter));
        System.out.println("Thuộc trường: " + (truong != null ? 
            truong.getTenTruong() + " (Mã: " + truong.getMaTruong() + ")" : "Chưa có trường"));
        System.out.println("══════════════════════════════════════════════");
    }
    // Xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n══════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                      DANH SÁCH KHOA");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-25s %-12s %-15s\n", "Mã khoa", "Tên khoa", "Ngày TL", "Trường");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────");
    }
}