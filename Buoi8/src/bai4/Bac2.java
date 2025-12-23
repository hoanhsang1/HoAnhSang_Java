package bai4;

import java.util.Scanner;

public class Bac2 {
    // Thuộc tính: hệ số a, b, c trong phương trình ax² + bx + c = 0
    private double heSoA;
    private double heSoB;
    private double heSoC;
    private Scanner sc;
    
    // 1. Hàm dựng rỗng
    public Bac2() {
        this.heSoA = 0;
        this.heSoB = 0;
        this.heSoC = 0;
        this.sc = new Scanner(System.in);
    }
    
    // 2. Hàm dựng có tham số
    public Bac2(double a, double b, double c) {
        this.heSoA = a;
        this.heSoB = b;
        this.heSoC = c;
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
    
    public double getHeSoC() {
        return heSoC;
    }
    
    public void setHeSoC(double heSoC) {
        this.heSoC = heSoC;
    }
    
    // 4. Nhập hệ số phương trình
    public void nhapHeSo() {
        System.out.println("\n=== NHẬP PHƯƠNG TRÌNH BẬC 2 ===");
        System.out.println("Dạng: ax² + bx + c = 0");
        
        System.out.print("Nhập hệ số a: ");
        this.heSoA = nhapSoThuc();
        
        System.out.print("Nhập hệ số b: ");
        this.heSoB = nhapSoThuc();
        
        System.out.print("Nhập hệ số c: ");
        this.heSoC = nhapSoThuc();
    }
    
    // 5. Giải phương trình bậc 2
    public void giaiPhuongTrinh() {
        System.out.println("\n=== GIẢI PHƯƠNG TRÌNH ===");
        System.out.println("Phương trình: " + inPhuongTrinh());
        
        // Kiểm tra hệ số a
        if (heSoA == 0) {
            System.out.println("Đây là phương trình bậc 1!");
            // Giải như phương trình bậc 1: bx + c = 0
            if (heSoB == 0) {
                if (heSoC == 0) {
                    System.out.println("Kết quả: Vô số nghiệm!");
                } else {
                    System.out.println("Kết quả: Vô nghiệm!");
                }
            } else {
                double nghiem = -heSoC / heSoB;
                System.out.printf("Kết quả: x = %.4f\n", nghiem);
            }
            return;
        }
        
        // Tính delta
        double delta = heSoB * heSoB - 4 * heSoA * heSoC;
        System.out.printf("Delta = b² - 4ac = %.2f\n", delta);
        
        // Xét delta
        if (delta < 0) {
            System.out.println("Delta < 0: Phương trình vô nghiệm thực!");
        } 
        else if (delta == 0) {
            double nghiemKep = -heSoB / (2 * heSoA);
            System.out.println("Delta = 0: Phương trình có nghiệm kép!");
            System.out.printf("Nghiệm kép: x₁ = x₂ = %.4f\n", nghiemKep);
        } 
        else {
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-heSoB + sqrtDelta) / (2 * heSoA);
            double x2 = (-heSoB - sqrtDelta) / (2 * heSoA);
            
            System.out.println("Delta > 0: Phương trình có 2 nghiệm phân biệt!");
            System.out.printf("Nghiệm 1: x₁ = %.4f\n", x1);
            System.out.printf("Nghiệm 2: x₂ = %.4f\n", x2);
        }
    }
    
    // 6. Tính delta
    public double tinhDelta() {
        return heSoB * heSoB - 4 * heSoA * heSoC;
    }
    
    // 7. Kiểm tra loại phương trình
    public void kiemTraLoaiPhuongTrinh() {
        System.out.println("\n=== PHÂN TÍCH PHƯƠNG TRÌNH ===");
        System.out.println("Phương trình: " + inPhuongTrinh());
        
        if (heSoA == 0) {
            System.out.println("→ Đây là phương trình bậc 1");
            if (heSoB == 0) {
                if (heSoC == 0) {
                    System.out.println("→ Phương trình đồng nhất: vô số nghiệm");
                } else {
                    System.out.println("→ Phương trình vô nghiệm");
                }
            } else {
                System.out.println("→ Phương trình bậc 1 có 1 nghiệm");
            }
        } else {
            double delta = tinhDelta();
            System.out.printf("→ Delta = %.2f\n", delta);
            
            if (delta < 0) {
                System.out.println("→ Phương trình vô nghiệm thực");
            } else if (delta == 0) {
                System.out.println("→ Phương trình có nghiệm kép");
            } else {
                System.out.println("→ Phương trình có 2 nghiệm phân biệt");
            }
        }
    }
    
    // 8. Xuất phương trình dạng chuỗi
    public String inPhuongTrinh() {
        if (heSoA == 0 && heSoB == 0 && heSoC == 0) {
            return "0 = 0";
        }
        
        StringBuilder pt = new StringBuilder();
        
        // Phần ax²
        if (heSoA != 0) {
            if (heSoA == 1) pt.append("x²");
            else if (heSoA == -1) pt.append("-x²");
            else pt.append(heSoA).append("x²");
        }
        
        // Phần bx
        if (heSoB != 0) {
            if (pt.length() > 0) {
                if (heSoB > 0) pt.append(" + ");
                else pt.append(" - ");
            } else {
                if (heSoB < 0) pt.append("-");
            }
            
            double absB = Math.abs(heSoB);
            if (absB == 1) pt.append("x");
            else pt.append(absB).append("x");
        }
        
        // Phần c
        if (heSoC != 0) {
            if (pt.length() > 0) {
                if (heSoC > 0) pt.append(" + ");
                else pt.append(" - ");
            } else {
                if (heSoC < 0) pt.append("-");
            }
            pt.append(Math.abs(heSoC));
        }
        
        if (pt.length() == 0) {
            return "0 = 0";
        }
        
        return pt.toString() + " = 0";
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
