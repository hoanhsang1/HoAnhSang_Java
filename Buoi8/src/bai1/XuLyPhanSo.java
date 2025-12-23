package bai1;

import java.util.Scanner;

public class XuLyPhanSo {
    private Scanner sc;
    
    public XuLyPhanSo() {
        sc = new Scanner(System.in);
    }
    
    // 1. Nhập phân số
    public PhanSo nhapPhanSo() {
        System.out.print("Nhập tử số: ");
        int tu = nhapSoNguyen();
        
        int mau;
        while (true) {
            System.out.print("Nhập mẫu số: ");
            mau = nhapSoNguyen();
            if (mau != 0) break;
            System.out.println("Mẫu số không được bằng 0!");
        }
        
        return new PhanSo(tu, mau);
    }
    
    // 2. Nhập số nguyên
    private int nhapSoNguyen() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số nguyên: ");
            }
        }
    }
}