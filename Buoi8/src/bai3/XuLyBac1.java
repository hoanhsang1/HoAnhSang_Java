package bai3;

import java.util.Scanner;

public class XuLyBac1 {
    private Scanner sc;
    
    public XuLyBac1() {
        sc = new Scanner(System.in);
    }
    
    // Tạo phương trình từ hệ số
    public Bac1 taoPhuongTrinh(double a, double b) {
        return new Bac1(a, b);
    }
    
    // Nhập phương trình từ bàn phím
    public Bac1 nhapPhuongTrinh() {
        Bac1 pt = new Bac1();
        pt.nhapHeSo();
        return pt;
    }
    
    // Giải nhiều phương trình
    public void giaiNhieuPhuongTrinh(Bac1[] danhSachPT) {
        System.out.println("\n=== GIẢI NHIỀU PHƯƠNG TRÌNH ===");
        for (int i = 0; i < danhSachPT.length; i++) {
            System.out.println("\nPhương trình " + (i+1) + ": " + 
                             danhSachPT[i].inPhuongTrinh());
            danhSachPT[i].giaiPhuongTrinh();
        }
    }
    
    // So sánh 2 phương trình (song song, trùng nhau, cắt nhau)
    public void soSanhHaiPhuongTrinh(Bac1 pt1, Bac1 pt2) {
        System.out.println("\n=== SO SÁNH 2 PHƯƠNG TRÌNH ===");
        System.out.println("PT1: " + pt1.inPhuongTrinh());
        System.out.println("PT2: " + pt2.inPhuongTrinh());
        
        if (pt1.getHeSoA() == pt2.getHeSoA()) {
            if (pt1.getHeSoB() == pt2.getHeSoB()) {
                System.out.println("→ Hai đường thẳng TRÙNG NHAU");
            } else {
                System.out.println("→ Hai đường thẳng SONG SONG");
            }
        } else {
            // Tính giao điểm
            double xGiao = (pt2.getHeSoB() - pt1.getHeSoB()) / 
                          (pt1.getHeSoA() - pt2.getHeSoA());
            double yGiao = pt1.getHeSoA() * xGiao + pt1.getHeSoB();
            System.out.printf("→ Hai đường thẳng CẮT NHAU tại (%.2f, %.2f)\n", 
                            xGiao, yGiao);
        }
    }
}
