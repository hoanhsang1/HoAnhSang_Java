package bai3;

import java.util.Scanner;

public class MenuBac1 {
    public static void main(String[] args) {
        Bac1 pt = new Bac1();
        Scanner sc = new Scanner(System.in);
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("      GIẢI PHƯƠNG TRÌNH BẬC 1");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập phương trình (ax + b = 0)");
            System.out.println("2. Giải phương trình");
            System.out.println("3. Kiểm tra loại phương trình");
            System.out.println("4. Tính giá trị tại x");
            System.out.println("5. Xem phương trình");
            System.out.println("6. Kiểm tra nghiệm");
            System.out.println("0. Thoát");
            System.out.println("══════════════════════════════════════════");
            System.out.print("Chọn chức năng: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                chon = -1;
            }
            
            switch (chon) {
                case 1:
                    pt.nhapHeSo();
                    System.out.println("Đã nhập phương trình: " + pt.inPhuongTrinh());
                    break;
                    
                case 2:
                    pt.giaiPhuongTrinh();
                    break;
                    
                case 3:
                    pt.kiemTraLoaiPhuongTrinh();
                    break;
                    
                case 4:
                    System.out.print("\nNhập giá trị x cần tính: ");
                    try {
                        double x = Double.parseDouble(sc.nextLine());
                        double ketQua = pt.tinhGiaTriTaiX(x);
                        System.out.printf("Tại x = %.2f: %.2fx + %.2f = %.4f\n", 
                                        x, pt.getHeSoA(), pt.getHeSoB(), ketQua);
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n=== PHƯƠNG TRÌNH HIỆN TẠI ===");
                    System.out.println("Dạng phương trình: " + pt.inPhuongTrinh());
                    System.out.println("Dạng hàm số: " + pt.inHamSo());
                    System.out.println("Hệ số a = " + pt.getHeSoA());
                    System.out.println("Hệ số b = " + pt.getHeSoB());
                    break;
                    
                case 6:
                    System.out.print("\nNhập nghiệm x cần kiểm tra: ");
                    try {
                        double x = Double.parseDouble(sc.nextLine());
                        if (pt.kiemTraNghiem(x)) {
                            System.out.printf("x = %.2f là nghiệm đúng!\n", x);
                        } else {
                            System.out.printf("x = %.2f KHÔNG phải nghiệm!\n", x);
                        }
                    } catch (Exception e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                    break;
                    
                case 0:
                    System.out.println("\nCảm ơn đã sử dụng chương trình!");
                    break;
                    
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            
        } while (chon != 0);
    }
}
