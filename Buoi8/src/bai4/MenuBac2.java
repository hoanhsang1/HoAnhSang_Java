package bai4;

import java.util.Scanner;

public class MenuBac2 {
    public static void main(String[] args) {
        Bac2 pt = new Bac2();
        Scanner sc = new Scanner(System.in);
        int chon;
        
        do {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("      GIẢI PHƯƠNG TRÌNH BẬC 2");
            System.out.println("══════════════════════════════════════════");
            System.out.println("1. Nhập phương trình (ax² + bx + c = 0)");
            System.out.println("2. Giải phương trình");
            System.out.println("3. Tính delta");
            System.out.println("4. Kiểm tra loại phương trình");
            System.out.println("5. Xem phương trình");
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
                    System.out.println("Đã nhập: " + pt.inPhuongTrinh());
                    break;
                    
                case 2:
                    pt.giaiPhuongTrinh();
                    break;
                    
                case 3:
                    System.out.println("\n=== TÍNH DELTA ===");
                    System.out.println("Phương trình: " + pt.inPhuongTrinh());
                    double delta = pt.tinhDelta();
                    System.out.printf("Delta = b² - 4ac = %.4f\n", delta);
                    
                    if (delta < 0) {
                        System.out.println("Delta < 0 → Vô nghiệm thực");
                    } else if (delta == 0) {
                        System.out.println("Delta = 0 → Nghiệm kép");
                    } else {
                        System.out.println("Delta > 0 → 2 nghiệm phân biệt");
                    }
                    break;
                    
                case 4:
                    pt.kiemTraLoaiPhuongTrinh();
                    break;
                    
                case 5:
                    System.out.println("\n=== THÔNG TIN PHƯƠNG TRÌNH ===");
                    System.out.println("Phương trình: " + pt.inPhuongTrinh());
                    System.out.println("Hệ số a = " + pt.getHeSoA());
                    System.out.println("Hệ số b = " + pt.getHeSoB());
                    System.out.println("Hệ số c = " + pt.getHeSoC());
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
