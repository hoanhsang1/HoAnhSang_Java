package quanlysinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class Faculty {
    private String maKhoa;
    private String tenKhoa;
    private Date ngayThanhLap;
    private ArrayList<SinhVien> danhSachSV;
    
    public Faculty() {
        ngayThanhLap = new Date();
        danhSachSV = new ArrayList<>();
    }
    
    public Faculty(String maKhoa, String tenKhoa) {
        this();
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
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
    
    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }
    
    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }
    
    public ArrayList<SinhVien> getDanhSachSV() {
        return danhSachSV;
    }
    
    // Thêm sinh viên
    public void themSinhVien(SinhVien sv) {
        danhSachSV.add(sv);
    }
    
    // Nhập thông tin khoa
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== NHẬP THÔNG TIN KHOA ===");
        
        this.maKhoa = inputNonEmptyString("Mã khoa: ");
        this.tenKhoa = inputNonEmptyString("Tên khoa: ");
        
        // Nhập và kiểm tra ngày thành lập khoa phải sau ngày thành lập trường
        while (true) {
            System.out.print("Nhập ngày thành lập khoa");
            this.ngayThanhLap = Date.nhapNgay("", 0);
            
            // Lấy trường hiện tại
            School truong = School.getInstance();
            if (truong.getNgayThanhLap() == null) {
                System.out.println("Vui lòng nhập thông tin trường trước!");
                return;
            }
            
            if (this.ngayThanhLap.isTruoc(truong.getNgayThanhLap())) {
                System.out.println("Lỗi: Ngày thành lập khoa phải sau ngày thành lập trường (" + 
                    truong.getNgayThanhLap().toString() + ")");
                continue;
            }
            break;
        }
    }
    
    // Xuất thông tin
    public void xuatThongTin() {
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("              THÔNG TIN KHOA");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("Mã khoa: " + maKhoa);
        System.out.println("Tên khoa: " + tenKhoa);
        System.out.println("Ngày thành lập: " + ngayThanhLap.toString());
        System.out.println("Số sinh viên: " + danhSachSV.size());
        System.out.println("══════════════════════════════════════════════");
    }
    
    // Helper methods
    private String inputNonEmptyString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Không được để trống!");
        }
    }
}