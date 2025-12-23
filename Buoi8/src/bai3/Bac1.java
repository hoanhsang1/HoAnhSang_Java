package bai3;

import java.util.Scanner;

public class Bac1 {
    // Thuộc tính: hệ số a, b trong phương trình ax + b = 0
    private double heSoA;
    private double heSoB;
    private Scanner sc;
    
    // 1. Hàm dựng rỗng
    public Bac1() {
        this.heSoA = 0;
        this.heSoB = 0;
        this.sc = new Scanner(System.in);
    }
    
    // 2. Hàm dựng có tham số
    public Bac1(double heSoA, double heSoB) {
        this.heSoA = heSoA;
        this.heSoB = heSoB;
        this.sc = new Scanner(System.in);
    }
    
    // 3. Getter - Setter
    public double getHeSoA() {
        return heSoA;
    }
    
    public void setHeSoA(double heSoA) {
        this.heSoA = heSoA;
    }
    
    public double getHeSoB() {
        return heSoB;
    }
    
    public void setHeSoB(double heSoB) {
        this.heSoB = heSoB;
    }
    
    // 4. Nhập hệ số phương trình
    public void nhapHeSo() {
        System.out.println("\n=== NHẬP PHƯƠNG TRÌNH BẬC 1 ===");
        System.out.println("Dạng: ax + b = 0");
        
        System.out.print("Nhập hệ số a: ");
        this.heSoA = nhapSoThuc();
        
        System.out.print("Nhập hệ số b: ");
        this.heSoB = nhapSoThuc();
    }
    
    // 5. Giải phương trình bậc 1 (ĐÃ SỬA THEO YÊU CẦU)
    public void giaiPhuongTrinh() {
        System.out.println("\n=== GIẢI PHƯƠNG TRÌNH ===");
        System.out.println("Phương trình: " + inPhuongTrinh());
        
        if (heSoA == 0) {
            if (heSoB == 0) {
                System.out.println("Kết quả: Phương trình có vô số nghiệm!");
            } else {
                System.out.println("Kết quả: Phương trình vô nghiệm!");
            }
        } else {
            double nghiem = -heSoB / heSoA;
            System.out.printf("Kết quả: x = %.4f\n", nghiem);
            System.out.printf("          ≈ %.2f\n", nghiem);
        }
    }
    
    // 6. Kiểm tra loại phương trình
    public void kiemTraLoaiPhuongTrinh() {
        System.out.println("\n=== PHÂN TÍCH PHƯƠNG TRÌNH ===");
        System.out.println("Phương trình: " + inPhuongTrinh());
        
        if (heSoA == 0) {
            if (heSoB == 0) {
                System.out.println("→ Là phương trình đồng nhất (0 = 0)");
                System.out.println("→ Có vô số nghiệm");
            } else {
                System.out.println("→ Là phương trình vô nghiệm (" + heSoB + " = 0)");
            }
        } else if (heSoB == 0) {
            System.out.println("→ Là phương trình thuần nhất (x = 0)");
            System.out.println("→ Có nghiệm duy nhất x = 0");
        } else {
            System.out.println("→ Là phương trình bậc 1 tổng quát");
            System.out.printf("→ Có nghiệm duy nhất x = %.2f\n", -heSoB / heSoA);
        }
    }
    
    // 7. Tính giá trị của phương trình tại x
    public double tinhGiaTriTaiX(double x) {
        return heSoA * x + heSoB;
    }
    
    // 8. Xuất phương trình dạng chuỗi
    public String inPhuongTrinh() {
        if (heSoA == 0 && heSoB == 0) {
            return "0 = 0";
        } else if (heSoA == 0) {
            return heSoB + " = 0";
        } else if (heSoB == 0) {
            if (heSoA == 1) return "x = 0";
            else if (heSoA == -1) return "-x = 0";
            else return heSoA + "x = 0";
        } else {
            String pt = "";
            
            // Phần ax
            if (heSoA == 1) pt = "x";
            else if (heSoA == -1) pt = "-x";
            else pt = heSoA + "x";
            
            // Phần + b
            if (heSoB > 0) pt += " + " + heSoB;
            else pt += " - " + (-heSoB);
            
            return pt + " = 0";
        }
    }
    
    // 9. Phương trình dạng hàm số y = ax + b
    public String inHamSo() {
        if (heSoA == 0) {
            return "y = " + heSoB;
        } else if (heSoB == 0) {
            if (heSoA == 1) return "y = x";
            else if (heSoA == -1) return "y = -x";
            else return "y = " + heSoA + "x";
        } else {
            String hamSo = "y = ";
            if (heSoA == 1) hamSo += "x";
            else if (heSoA == -1) hamSo += "-x";
            else hamSo += heSoA + "x";
            
            if (heSoB > 0) hamSo += " + " + heSoB;
            else hamSo += " - " + (-heSoB);
            
            return hamSo;
        }
    }
    
    // 10. Kiểm tra nghiệm đúng không
    public boolean kiemTraNghiem(double x) {
        double giaTri = tinhGiaTriTaiX(x);
        return Math.abs(giaTri) < 0.0001; // So sánh với 0 (sai số nhỏ)
    }
    
    // Hàm nhập số thực
    private double nhapSoThuc() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Vui lòng nhập số: ");
            }
        }
    }
}