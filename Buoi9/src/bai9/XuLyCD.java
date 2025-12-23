package bai9;

import java.util.Scanner;

public class XuLyCD {
    private Scanner sc;
    private QuanLyCD qlcd;
    
    public XuLyCD(QuanLyCD qlcd) {
        this.sc = new Scanner(System.in);
        this.qlcd = qlcd;
    }
    
    // Nhập thông tin CD mới
    public CD nhapCD() {
        System.out.println("\n=== NHẬP THÔNG TIN CD MỚI ===");
        
        // Nhập mã CD (không trùng)
        int maCD;
        while (true) {
            maCD = nhapSoNguyen("Mã CD (số nguyên): ");
            
            if (qlcd.timKiemTheoMa(maCD) != null) {
                System.out.println("⚠ Mã CD đã tồn tại! Vui lòng nhập mã khác.");
            } else {
                break;
            }
        }
        
        // Nhập tựa CD
        System.out.print("Tựa CD: ");
        String tuaCD = sc.nextLine();
        
        // Nhập ca sĩ
        System.out.print("Ca sĩ: ");
        String caSy = sc.nextLine();
        
        // Nhập số bài hát (>0)
        int soBaiHat;
        while (true) {
            soBaiHat = nhapSoNguyen("Số bài hát (>0): ");
            if (soBaiHat > 0) {
                break;
            }
            System.out.println("Số bài hát phải > 0!");
        }
        
        // Nhập giá thành (>0)
        double giaThanh;
        while (true) {
            giaThanh = nhapSoThuc("Giá thành (>0): ");
            if (giaThanh > 0) {
                break;
            }
            System.out.println("Giá thành phải > 0!");
        }
        
        // Tạo và trả về đối tượng CD
        return new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
    }
    
    // Nhập số nguyên
    public int nhapSoNguyen(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số nguyên: ");
            }
        }
    }
    
    // Nhập số thực
    public double nhapSoThuc(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số: ");
            }
        }
    }
    
    // Nhập lựa chọn menu
    public int nhapLuaChon(int min, int max) {
        while (true) {
            try {
                System.out.print("Chọn chức năng (" + min + "-" + max + "): ");
                int chon = Integer.parseInt(sc.nextLine());
                if (chon >= min && chon <= max) {
                    return chon;
                }
                System.out.println("Vui lòng chọn từ " + min + " đến " + max + "!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }
}