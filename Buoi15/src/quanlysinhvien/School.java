package quanlysinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
    private String maTruong;
    private String tenTruong;
    private Date ngayThanhLap;
    private ArrayList<Faculty> danhSachKhoa;
    
    // SINGLETON PATTERN - chỉ 1 trường duy nhất
    private static School instance = null;
    
    // Constructor private
    private School() {
        danhSachKhoa = new ArrayList<>();
        ngayThanhLap = new Date();
    }
    
    // Get instance duy nhất
    public static School getInstance() {
        if (instance == null) {
            instance = new School();
        }
        return instance;
    }
    
    // Getter - Setter
    public String getMaTruong() {
        return maTruong;
    }
    
    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }
    
    public String getTenTruong() {
        return tenTruong;
    }
    
    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }
    
    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }
    
    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }
    
    public ArrayList<Faculty> getDanhSachKhoa() {
        return danhSachKhoa;
    }
    
    // Thêm khoa
    public void themKhoa(Faculty khoa) {
        // Kiểm tra khoa phải thành lập sau trường
        if (khoa.getNgayThanhLap().isTruoc(this.ngayThanhLap)) {
            System.out.println("Lỗi: Ngày thành lập khoa không được trước ngày thành lập trường!");
            return;
        }
        danhSachKhoa.add(khoa);
    }
    
    // Nhập thông tin trường (chỉ nhập 1 lần)
    public void nhapThongTin() {
        if (this.maTruong != null) {
            System.out.println("Trường đã được nhập thông tin trước đó!");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== NHẬP THÔNG TIN TRƯỜNG ĐHCN ===");
        
        this.maTruong = inputNonEmptyString("Mã trường: ");
        this.tenTruong = inputNonEmptyString("Tên trường: ");
        System.out.print("Nhập ngày thành lập trường");
        this.ngayThanhLap = Date.nhapNgay("", 0);
        
        System.out.println("✓ Đã tạo trường: " + this.tenTruong);
    }
    
    // Xuất thông tin
    public void xuatThongTin() {
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("          THÔNG TIN TRƯỜNG ĐHCN");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("Mã trường: " + maTruong);
        System.out.println("Tên trường: " + tenTruong);
        System.out.println("Ngày thành lập: " + ngayThanhLap.toString());
        System.out.println("Số khoa: " + danhSachKhoa.size());
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