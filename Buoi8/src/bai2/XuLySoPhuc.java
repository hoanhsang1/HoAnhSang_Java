package bai2;

import java.util.Scanner;

public class XuLySoPhuc {
    private Scanner sc;
    
    public XuLySoPhuc() {
        sc = new Scanner(System.in);
    }
    
    // 1. Nhập số phức
    public SoPhuc nhapSoPhuc(String tenSoPhuc) {
        System.out.println("\n--- NHẬP " + tenSoPhuc + " ---");
        System.out.print("Nhập phần thực: ");
        double thuc = nhapSoThuc();
        
        System.out.print("Nhập phần ảo: ");
        double ao = nhapSoThuc();
        
        return new SoPhuc(thuc, ao);
    }
    
    // 2. Nhập số thực
    private double nhapSoThuc() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số: ");
            }
        }
    }
    
    // 3. Nhập số nguyên
    public int nhapSoNguyen(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số nguyên: ");
            }
        }
    }
}
