package bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    private static Solve solve;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        solve = new Solve();
        scanner = new Scanner(System.in);
        hienThiMenu();
    }
    
    private static void hienThiMenu() {
        int choice;
        do {
            System.out.println("\n=== MENU QUAN LY NHAN VIEN ===");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. In danh sach tat ca nhan vien");
            System.out.println("3. In danh sach nhan vien Full Time");
            System.out.println("4. In danh sach nhan vien Part Time");
            System.out.println("5. Tim nhan vien co luong cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            switch (choice) {
                case 1:
                	solve.taoDanhSach();
                    break;
                case 2:
                    inDanhSachTatCa();
                    break;
                case 3:
                    inDanhSachFullTime();
                    break;
                case 4:
                    inDanhSachPartTime();
                    break;
                case 5:
                    timNVCaoNhat();
                    break;
         
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
        scanner.close();
    }
    
    private static void inDanhSachTatCa() {
        System.out.println("\n=== DANH SACH TAT CA NHAN VIEN ===");
        System.out.println("Format: Loai|MaNV|Ho ten|Tuoi|Luong");
        System.out.println("----------------------------------------------------------------");
        
        if (solve.isDanhSachRong()) {
            System.out.println("Danh sach rong!");
            return;
        }
        
        ArrayList<Employee> ds = solve.getDanhSachNV();
        for (Employee emp : ds) {
            System.out.println(emp.toString());
        }
    }
    
    private static void inDanhSachFullTime() {
        System.out.println("\n=== DANH SACH NHAN VIEN FULL TIME ===");
        System.out.println("Format: FULL|MaNV|Ho ten|Tuoi|Luong|He so luong|Luong co ban");
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<FullTimeEmployee> ds = solve.getDanhSachFullTime();
        if (ds.isEmpty()) {
            System.out.println("Khong co nhan vien Full Time!");
            return;
        }
        
        for (FullTimeEmployee emp : ds) {
            System.out.println(emp.toString());
        }
    }
    
    private static void inDanhSachPartTime() {
        System.out.println("\n=== DANH SACH NHAN VIEN PART TIME ===");
        System.out.println("Format: PART|MaNV|Ho ten|Tuoi|Luong|He so luong|So gio|Don gia");
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<PartTimeEmployee> ds = solve.getDanhSachPartTime();
        if (ds.isEmpty()) {
            System.out.println("Khong co nhan vien Part Time!");
            return;
        }
        
        for (PartTimeEmployee emp : ds) {
            System.out.println(emp.toString());
        }
    }
    
    private static void timNVCaoNhat() {
        System.out.println("\n=== TIM NHAN VIEN CO LUONG CAO NHAT ===");
        
        Employee nvMax = solve.timNVCaoNhat();
        if (nvMax == null) {
            System.out.println("Danh sach rong!");
            return;
        }
        
        System.out.println("Nhan vien co luong cao nhat:");
        System.out.println(nvMax.toString());
    }
    
   
}